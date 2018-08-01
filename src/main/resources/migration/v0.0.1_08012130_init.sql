DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
  username VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  nickname VARCHAR(20),
  email VARCHAR(30) NOT NULL,
  phone CHAR(11),
  role SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0: 普通用户, 1: 管理员, 2: 超级管理员',
  status SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0: 正常, 1: 禁用',
  create_time DATETIME NOT NULL DEFAULT NOW(),
  create_by VARCHAR(10) NOT NULL,
  update_time DATETIME NOT NULL DEFAULT NOW(),
  UNIQUE KEY username (username)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO user (username, password, nickname, email, role, create_by) VALUES ('admin', '111111', '超级管理员', '1761869346@qq.com', 2, 'admin');