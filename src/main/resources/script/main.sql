CREATE TABLE requirement
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    requirement_name  VARCHAR(255),
    detail_id         INT,
    owner_id          INT,
    status            VARCHAR(50),
    due_date          DATE,
    priority          ENUM ('Low', 'Medium', 'High'),
    create_time       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_update       VARCHAR(255)
);

-- //创建一个用户表,表名为owner,用于存储需求的拥有者信息,数据库为mysql,字段为Owner类的属性：
create table owner
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255),
    password    VARCHAR(255),
    email       VARCHAR(255),
    phone       VARCHAR(255),
    avatar      VARCHAR(255),
    role        VARCHAR(255),
    status      VARCHAR(255),
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


# bug表：字段如下
# 1. `Bug_ID`：唯一标识缺陷的编号。
# 2. `Title`：BUG简短描述或标题。
# 3. `Description`：BUG的详细描述。
# 4. `Status`：BUG的当前状态（例如：新建、进行中、已解决、重新打开、已关闭等）。
# 5. `Priority`：BUG的优先级（通常是：低、中、高）。
# 6. `Severity`：BUG的严重程度（例如：轻微、一般、严重、致命）。
# 7. `Reporter`：报告BUG的用户或者测试人员姓名。
# 8. `Assignee`：被分配处理BUG的开发人员姓名。
# 9. `Creation_Date`：BUG报告创建日期。
# 10. `Update_Date`：BUG记录最后一次更新日期。
# 11. `Fixed_Version`：BUG被修复的版本号。
# 12. `Resolution`：BUG解决的方式。
# 13. `Reproduce_Steps`：BUG复现步骤。
# 14. `Attachments`：相关附件，例如截图、日志文件等。
# 15. `Comments`：BUG的备注，评论或讨论。
# - `Project_ID` / `Module`：BUG所在项目或模块的名称或编号。
# - `Environment`：BUG出现的环境（例如：测试环境、生产环境等）。
# - `Detected_In_Version`：BUG发现时的版本号。
# - `Browser`/ `OS`：BUG出现时的浏览器或操作系统信息（如果适用的话）。
# - `Due_Date`：BUG计划解决的截止日期。
# - `Related_Issues`：相关问题、需求或其他BUG的引用链接。

CREATE TABLE `bug` (
                       `id` int NOT NULL AUTO_INCREMENT,
                       `title` varchar(255) DEFAULT NULL,
                       `description` varchar(255) DEFAULT NULL,
                       `status` varchar(255) DEFAULT NULL,
                       `priority` varchar(255) DEFAULT NULL,
                       `damage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                       `creator_id` int DEFAULT NULL,
                       `relavant_id` int DEFAULT NULL,
                       `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                       `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                       `resolution` varchar(255) DEFAULT NULL,
                       `comments_id` int DEFAULT NULL,
                       `requirement_id` int DEFAULT NULL,
                       `env` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                       `version` varchar(255) DEFAULT NULL,
                       `related_issues` varchar(255) DEFAULT NULL,
                       `processor_id` int NOT NULL,
                       `identifier_id` int NOT NULL,
                       PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
# 向bug表插入数据，default表示使用默认值，description尽量200个字符
insert into bug (title, description, status, priority, damage, creator_id, relavant_id, resolution, comments_id, requirement_id, env, version, related_issues, processor_id, identifier_id) values ('bug1', 'bug1', 'new', 'low', 'low', 1, 1, 'default', 1, 1, 'default', 'default', 'default', 1, 1);



# 新增文件表，用于存储文件信息
create table file
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    link_id     INT,
    name        VARCHAR(255),
    path        VARCHAR(255),
    type        VARCHAR(255),
    size        VARCHAR(255),
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

# 新增用户表，用于存储用户信息
create table user
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255),
    account     VARCHAR(255),
    password    VARCHAR(255),
    email       VARCHAR(255),
    phone       VARCHAR(255),
    avatar      VARCHAR(255),
    role        VARCHAR(255),
    status      VARCHAR(255),
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
# 给user表，和字段加中文注释
alter table user comment '用户表';
alter table user modify column id int comment '用户id';
alter table user modify column name varchar(255) comment '用户姓名';
alter table user modify column account varchar(255) comment '用户账号';
alter table user modify column password varchar(255) comment '用户密码';
alter table user modify column email varchar(255) comment '用户邮箱';
alter table user modify column phone varchar(255) comment '用户电话';
alter table user modify column avatar varchar(255) comment '用户头像';
alter table user modify column role varchar(255) comment '用户角色:admin-管理员,developer-开发者,tester-测试人员,product-产品经理';
alter table user modify column status varchar(255) comment '用户状态:0-禁用,1-启用';
alter table user modify column create_time timestamp comment '创建时间';
alter table user modify column update_time timestamp comment '更新时间';

# 给user表添加数据






