INSERT IGNORE INTO `tt_role`(id,`name`,description,created_time,role) VALUES
(1,'超级管理员','管理员拥有所有接口操作权限',NOW(),'ADMIN'),
(2,'用户','普通拥有查看用户列表与修改密码权限，不具备对用户增删改权限',NOW(),'USER');

