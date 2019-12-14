SET NAMES utf8;
-- 初始化表
DROP DATABASE IF EXISTS auth_service;
CREATE DATABASE auth_service DEFAULT CHARSET utf8mb4;
USE auth_service;

-- access_token存储表
DROP TABLE IF EXISTS oauth_access_token;
CREATE TABLE oauth_access_token
(   create_time datetime default now() COMMENT '创建时间',
    token_id          VARCHAR(256) COMMENT 'MD5加密的access_token的值',
    token             BLOB COMMENT 'OAuth2AccessToken.java对象序列化后的二进制数据',
    authentication_id VARCHAR(256) COMMENT '该字段具有唯一性,MD5加密过的username,client_id,scope',
    user_name         VARCHAR(256) COMMENT '登录的用户名',
    client_id         VARCHAR(256) COMMENT '客户端ID',
    authentication    BLOB COMMENT 'OAuth2Authentication.java对象序列化后的二进制数据',
    refresh_token     VARCHAR(256) COMMENT 'MD5加密果的refresh_token的值'
) COMMENT '访问令牌表,在项目中,主要操作oauth_access_token表的对象是JdbcTokenStore.java';

-- refresh_token存储表
DROP TABLE IF EXISTS oauth_refresh_token;
CREATE TABLE oauth_refresh_token
(   create_time datetime default now() COMMENT '创建时间',
    token_id       VARCHAR(256) COMMENT 'MD5加密过的refresh_token的值',
    token          BLOB COMMENT 'OAuth2RefreshToken.java对象序列化后的二进制数据',
    authentication BLOB COMMENT 'OAuth2Authentication.java对象序列化后的二进制数据'
) COMMENT '更新令牌表,在项目中,主要操作oauth_refresh_token表的对象是JdbcTokenStore.java. ' ||
 '(与操作oauth_access_token表的对象一样);如果客户端的grant_type不支持refresh_token,则不会使用该表';

-- 授权记录表
DROP TABLE IF EXISTS oauth_approvals;
CREATE TABLE oauth_approvals
(   create_time datetime default now() COMMENT '创建时间',
    user_id         VARCHAR(256) COMMENT '登录的用户名',
    client_id       VARCHAR(256) COMMENT '客户端ID',
    scope          VARCHAR(256) COMMENT '申请的权限范围',
    status         VARCHAR(10) COMMENT '状态（Approve或Deny）',
    expires_at      DATETIME COMMENT '过期时间',
    last_modified_at DATETIME COMMENT '最终修改时间'
) COMMENT '授权记录表';

-- 授权码表
DROP TABLE IF EXISTS oauth_code;
CREATE TABLE oauth_code
(   create_time datetime default now() COMMENT '创建时间',
    code           VARCHAR(256) COMMENT '授权码(未加密)',
    authentication BLOB COMMENT 'AuthorizationRequestHolder.java对象序列化后的二进制数据'
) COMMENT '授权码表,在项目中,主要操作oauth_code表的对象是JdbcAuthorizationCodeServices.java. ' ||
 '只有当grant_type为"authorization_code"时,该表中才会有数据产生; 其他的grant_type没有使用该表';

-- client用户表
DROP TABLE IF EXISTS oauth_client_details;
CREATE TABLE oauth_client_details
(   create_time datetime default now() COMMENT '创建时间',
    client_id               VARCHAR(256) NOT NULL COMMENT '客户端ID,主键,必须唯一,不能为空.' ||
     '用于唯一标识每一个客户端(client); 在注册时必须填写(也可由服务端自动生成).' ||
      '对于不同的grant_type,该字段都是必须的. 在实际应用中的另一个名称叫appKey,与client_id是同一个概念',
    resource_ids            VARCHAR(256) COMMENT '资源ID集合,多个资源时用逗号(,)分隔',
    client_secret           VARCHAR(256) COMMENT '客户端密匙',
    scope                   VARCHAR(256) COMMENT '客户端申请的权限范围',
    authorized_grant_types  VARCHAR(256) COMMENT '客户端支持的grant_type',
    web_server_redirect_uri VARCHAR(256) COMMENT '重定向URI',
    authorities             VARCHAR(256) COMMENT '客户端所拥有的Spring Security的权限值，多个用逗号(,)分隔',
    access_token_validity   INTEGER COMMENT '访问令牌有效时间值(单位:秒)',
    refresh_token_validity  INTEGER COMMENT '更新令牌有效时间值(单位:秒)',
    additional_information  VARCHAR(4096) COMMENT '预留字段',
    archived tinyint(1) default '0' COMMENT '用于标识客户端是否已存档(即实现逻辑删除),默认值为''0''(即未存档). ' ||
     '对该字段的具体使用请参考CustomJdbcClientDetailsService.java,在该类中,扩展了在查询client_details的SQL加上archived = 0条件 (扩展字段)',
    trusted tinyint(1) default '0' COMMENT '设置客户端是否为受信任的,默认为''0''(即不受信任的,1为受信任的).' ||
     '该字段只适用于grant_type="authorization_code"的情况,当用户登录成功后,若该值为0,则会跳转到让用户Approve的页面让用户同意授权,' ||
      '若该字段为1,则在登录后不需要再让用户Approve同意授权(因为是受信任的).对该字段的具体使用请参考OauthUserApprovalHandler.java. (扩展字段)',
    auto_approve             VARCHAR(256) COMMENT '用户是否自动Approval操作,默认值为 ''false'', ' ||
     '可选值包括 ''true'',''false'', ''read'',''write''.该字段只适用于grant_type="authorization_code"的情况,' ||
      '当用户登录成功后,若该值为''true''或支持的scope值,则会跳过用户Approve的页面, 直接授权.该字段与 trusted 有类似的功能,' ||
       ' 是 spring-security-oauth2 的 2.0 版本后添加的新属性',
    CONSTRAINT pk_oauth_client_details_client_id PRIMARY KEY (client_id)
) COMMENT '客户端信息,在项目中,主要操作oauth_code表的对象是JdbcAuthorizationCodeServices.java.' ||
 '只有当grant_type为"authorization_code"时,该表中才会有数据产生; 其他的grant_type没有使用该表';

-- 客户端授权令牌表
DROP TABLE IF EXISTS oauth_client_token;
CREATE TABLE oauth_client_token
(   create_time datetime default now() COMMENT '创建时间',
    token_id          VARCHAR(256) COMMENT 'MD5加密的access_token值',
    token             BLOB COMMENT 'OAuth2AccessToken.java对象序列化后的二进制数据',
    authentication_id VARCHAR(256) COMMENT 'MD5加密过的username,client_id,scope',
    user_name         VARCHAR(256) COMMENT '登录的用户名',
    client_id         VARCHAR(256) COMMENT '客户端ID'
) COMMENT '客户端授权令牌表';

