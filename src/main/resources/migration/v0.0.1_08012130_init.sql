DROP TABLE IF EXISTS log;
DROP TABLE IF EXISTS site;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS article;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS user_status;

CREATE TABLE user_role (
  code CHAR(10) PRIMARY KEY NOT NULL,
  name CHAR(10) NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO user_role (code, name) VALUES ('ordinary', '普通用户'), ('admin', '管理员');

CREATE TABLE user_status (
  code CHAR(10) PRIMARY KEY NOT NULL,
  name CHAR(10) NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO user_status (code, name) VALUES ('normal', '正常'), ('forbidden', '禁用');

CREATE TABLE user (
  id TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
  username VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  nickname VARCHAR(20),
  email VARCHAR(30) NOT NULL,
  phone CHAR(11),
  qq VARCHAR(15),
  role CHAR(10) NOT NULL DEFAULT 'ordinary',
  status CHAR(10) NOT NULL DEFAULT 'normal',
  create_by VARCHAR(20) NOT NULL,
  create_time DATETIME NOT NULL DEFAULT NOW(),
  update_by VARCHAR(20) NOT NULL,
  update_time DATETIME NOT NULL DEFAULT NOW(),
  last_login_time DATETIME,
  UNIQUE KEY username (username)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO user (username, password, nickname, email, role, create_by, update_by) VALUES ('admin', '111111', '超级管理员', '1761869346@qq.com', 'admin', 'admin', 'admin');

CREATE TABLE category (
  id VARCHAR(20) PRIMARY KEY NOT NULL,
  parent_id VARCHAR(20),
  name VARCHAR(20) NOT NULL,
  keywords VARCHAR(200),
  description VARCHAR(200),
  content VARCHAR(20000),
  banner VARCHAR(100) COMMENT '分类banner地址',
  thumbnail VARCHAR(100) COMMENT '分类缩略图地址',
  status TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0: 正常, 1: 不显示, 2: 不可链接',
  sort TINYINT UNSIGNED,
  create_by VARCHAR(20) NOT NULL,
  create_time DATETIME NOT NULL DEFAULT NOW(),
  update_by VARCHAR(20) NOT NULL,
  update_time DATETIME  NOT NULL DEFAULT NOW()
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE article (
  id CHAR(20) PRIMARY KEY NOT NULL,
  title VARCHAR(200) NOT NULL,
  keywords VARCHAR(200),
  description VARCHAR(200),
  content VARCHAR(20000) NOT NULL,
  banner VARCHAR(100) COMMENT '文章banner地址',
  thumbnail VARCHAR(100) COMMENT '文章缩略图地址',
  status TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0: 正常, 1: 不显示',
  sort INT UNSIGNED,
  category_id VARCHAR(20) NOT NULL,
  create_by VARCHAR(20) NOT NULL,
  create_time DATETIME NOT NULL DEFAULT NOW(),
  update_by VARCHAR(20) NOT NULL,
  update_time DATETIME NOT NULL DEFAULT NOW(),
  CONSTRAINT ibfk_article_1 FOREIGN KEY (category_id) REFERENCES category (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE comment (
  id CHAR(20) PRIMARY KEY NOT NULL,
  nickname VARCHAR(20) NOT NULL,
  ip CHAR(20) NOT NULL,
  email VARCHAR(30),
  phone CHAR(11),
  qq VARCHAR(15),
  conent VARCHAR(200) NOT NULL,
  status TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0: 正常, 1: 不显示',
  article_id VARCHAR(20) NOT NULL,
  create_by VARCHAR(20) NOT NULL,
  create_time DATETIME NOT NULL DEFAULT NOW(),
  update_by VARCHAR(20) NOT NULL,
  update_time DATETIME NOT NULL DEFAULT NOW(),
  CONSTRAINT ibfk_comment_1 FOREIGN KEY (article_id) REFERENCES article (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE site (
  id TINYINT UNSIGNED PRIMARY KEY DEFAULT 0,
  name VARCHAR(200) NOT NULL,
  title VARCHAR(200) NOT NULL,
  keywords VARCHAR(200),
  description VARCHAR(200),
  email VARCHAR(20),
  phone VARCHAR(11),
  qq VARCHAR(15),
  telephone VARCHAR(20),
  icp VARCHAR(20),
  create_by VARCHAR(20) NOT NULL,
  create_time DATETIME NOT NULL DEFAULT NOW(),
  update_by VARCHAR(20) NOT NULL,
  update_time DATETIME  NOT NULL DEFAULT NOW()
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE log (
  id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
  username VARCHAR(20) NOT NULL,
  ip CHAR(20) NOT NULL,
  operation TINYINT NOT NULL DEFAULT 0 COMMENT '0: 新增, 1: 修改, 2: 删除',
  type TINYINT NOT NULL DEFAULT 0 COMMENT '0: 分类, 1: 文章, 2: 评论',
  content VARCHAR(200) NOT NULL,
  create_time DATETIME NOT NULL DEFAULT NOW()
) ENGINE = InnoDB DEFAULT CHARSET = utf8;