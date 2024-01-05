CREATE TABLE requirement (
  id INT AUTO_INCREMENT PRIMARY KEY,
  requirement_name VARCHAR(255),
  detail_id INT,
  owner_id INT,
  status VARCHAR(50),
  due_date DATE,
  priority ENUM('Low', 'Medium', 'High'),
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  last_updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  last_update VARCHAR(255)
);

-- //创建一个用户表,表名为owner,用于存储需求的拥有者信息,数据库为mysql,字段为Owner类的属性：
create table owner (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  password VARCHAR(255),
  email VARCHAR(255),
  phone VARCHAR(255),
  avatar VARCHAR(255),
  role VARCHAR(255),
  status VARCHAR(255),
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);