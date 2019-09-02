# init  sample data


# 序列号
CREATE TABLE IF NOT EXISTS sequence_entity
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    sequence_name VARCHAR(50) COMMENT 'key值',
    current_value BIGINT    DEFAULT 1               NOT NULL
        COMMENT '当前值',
    version       INT       DEFAULT 0               NOT NULL,
    record_status INT       DEFAULT 0               NOT NULL,
    sort_priority INT       DEFAULT 0,
    remark        VARCHAR(255),
    date_created  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT unique_sequence_name UNIQUE (sequence_name)
);

# 资源表-角色表
CREATE TABLE IF NOT EXISTS resource_entity
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    url           VARCHAR(50)                       NOT NULL COMMENT 'url资源',
    roles         VARCHAR(50)                       NOT NULL COMMENT '该资源此类角色可访问',
    version       INT       DEFAULT 0               NOT NULL,
    record_status INT       DEFAULT 0               NOT NULL,
    sort_priority INT       DEFAULT 0,
    remark        VARCHAR(255),
    date_created  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT unique_url UNIQUE (url)
);

insert into resource_entity(url, roles)
values ('/admin/user/**', 'ROLE_SUPER'),
       ('/admin/role/**', 'ROLE_SUPER'),
       ('/case/**', 'ROLE_USER,ROLE_SUPER');
