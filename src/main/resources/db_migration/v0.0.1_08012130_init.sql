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
  name CHAR(10) NOT NULL,
  sort TINYINT UNSIGNED NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE user_status (
  code CHAR(10) PRIMARY KEY NOT NULL,
  name CHAR(10) NOT NULL,
  sort TINYINT UNSIGNED NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE user (
  id CHAR(32) PRIMARY KEY NOT NULL,
  username VARCHAR(20) NOT NULL,
  password VARCHAR(80) NOT NULL,
  nickname VARCHAR(20),
  email VARCHAR(30) NOT NULL,
  phone CHAR(11),
  qq VARCHAR(15),
  role VARCHAR(10) NOT NULL DEFAULT 'ordinary',
  status VARCHAR(10) NOT NULL DEFAULT 'normal',
  create_by VARCHAR(20) NOT NULL,
  create_time DATETIME NOT NULL DEFAULT NOW(),
  update_by VARCHAR(20) NOT NULL,
  update_time DATETIME NOT NULL DEFAULT NOW(),
  last_login_time DATETIME,
  UNIQUE KEY username (username)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE category (
  id CHAR(32) PRIMARY KEY NOT NULL,
  parent_id VARCHAR(20),
  name VARCHAR(20) NOT NULL,
  keywords VARCHAR(200),
  description VARCHAR(200),
  content VARCHAR(20000),
  banner VARCHAR(100) COMMENT '分类banner地址',
  thumbnail VARCHAR(100) COMMENT '分类缩略图地址',
  status VARCHAR(10) NOT NULL DEFAULT 'normal' COMMENT 'normal: 正常, hide: 不显示',
  sort TINYINT UNSIGNED,
  create_by VARCHAR(20) NOT NULL,
  create_time DATETIME NOT NULL DEFAULT NOW(),
  update_by VARCHAR(20) NOT NULL,
  update_time DATETIME  NOT NULL DEFAULT NOW()
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE article (
  id CHAR(32) PRIMARY KEY NOT NULL,
  title VARCHAR(200) NOT NULL,
  keywords VARCHAR(200),
  description VARCHAR(200),
  content VARCHAR(20000) NOT NULL,
  banner VARCHAR(100) COMMENT '文章banner地址',
  thumbnail VARCHAR(100) COMMENT '文章缩略图地址',
  status VARCHAR(10) NOT NULL DEFAULT 'normal' COMMENT 'normal: 正常, hide: 不显示',
  sort INT UNSIGNED,
  category_id VARCHAR(20) NOT NULL,
  create_by VARCHAR(20) NOT NULL,
  create_time DATETIME NOT NULL DEFAULT NOW(),
  update_by VARCHAR(20) NOT NULL,
  update_time DATETIME NOT NULL DEFAULT NOW(),
  CONSTRAINT ibfk_article_1 FOREIGN KEY (category_id) REFERENCES category (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE comment (
  id CHAR(32) PRIMARY KEY NOT NULL,
  nickname VARCHAR(20) NOT NULL,
  ip CHAR(20) NOT NULL,
  email VARCHAR(30),
  phone CHAR(11),
  qq VARCHAR(15),
  conent VARCHAR(200) NOT NULL,
  status VARCHAR(10) NOT NULL DEFAULT 'normal' COMMENT 'normal: 正常, hide: 不显示',
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
  operation VARCHAR(10) NOT NULL DEFAULT 'create' COMMENT 'create: 新增, edit: 修改, delete: 删除',
  type VARCHAR(10) NOT NULL DEFAULT 'category' COMMENT 'category: 分类, article: 文章, comment: 评论',
  content VARCHAR(200) NOT NULL,
  create_time DATETIME NOT NULL DEFAULT NOW()
) ENGINE = InnoDB DEFAULT CHARSET = utf8;


INSERT INTO user_role (code, name, sort) VALUES ('ordinary', '普通用户', 1), ('admin', '管理员', 2);

INSERT INTO user_status (code, name, sort) VALUES ('normal', '正常', 1), ('forbidden', '禁用', 2);

INSERT INTO user (id, username, password, nickname, email, role, create_by, update_by) VALUES ('abc', 'admin', '111111', '超级管理员', '1761869346@qq.com', 'admin', 'admin', 'admin');
