CREATE TABLE IF NOT EXISTS gateway (
  id               BIGINT UNSIGNED NOT NULL  AUTO_INCREMENT,
  sn               VARCHAR(30)     NOT NULL,
  udid             VARCHAR(60)     NOT NULL,
  appId            VARCHAR(60)     NOT NULL,
  name             VARCHAR(30)     NOT NULL,
  type             VARCHAR(30)     NOT NULL,
  gatewayVersionId BIGINT UNSIGNED NOT NULL,
  createTime       TIMESTAMP       NOT NULL  DEFAULT CURRENT_TIMESTAMP,
  updateTime       TIMESTAMP       NULL      DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX uk_gateway_sn(sn) USING BTREE,
  UNIQUE INDEX uk_gateway_udid(udid) USING BTREE
)
  COMMENT '网关'
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;


CREATE TABLE IF NOT EXISTS locks (
  id            BIGINT UNSIGNED  NOT NULL  AUTO_INCREMENT,
  uuid          VARCHAR(36)      NOT NULL,
  gatewayId     BIGINT UNSIGNED  NOT NULL,
  deviceIndex   TINYINT UNSIGNED NOT NULL,
  name          VARCHAR(30)      NOT NULL,
  available     TINYINT          NOT NULL,

  superPassword VARCHAR(10)      NOT NULL,
  tempPassword  VARCHAR(10)      NOT NULL,

  locked        TINYINT UNSIGNED NOT NULL  DEFAULT 255,
  upLocked      TINYINT UNSIGNED NOT NULL  DEFAULT 255,
  backLocked    TINYINT UNSIGNED NOT NULL  DEFAULT 255,
  online        TINYINT UNSIGNED NOT NULL  DEFAULT 255,
  voltage       TINYINT UNSIGNED NOT NULL  DEFAULT 255,

  createTime    TIMESTAMP        NOT NULL  DEFAULT CURRENT_TIMESTAMP,
  updateTime    TIMESTAMP        NULL      DEFAULT NULL,
  pushTime      TIMESTAMP        NULL      DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX uk_locks_uuid(uuid) USING BTREE
)
  COMMENT '门锁'
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;


CREATE TABLE IF NOT EXISTS request (
  id           BIGINT UNSIGNED NOT NULL  AUTO_INCREMENT,
  sn           VARCHAR(36)     NOT NULL,
  uuid         VARCHAR(36)     NOT NULL,
  action       VARCHAR(20)     NOT NULL,
  params       VARCHAR(200),
  appId        VARCHAR(60)     NOT NULL,
  callback     VARCHAR(60),
  acceptTime   TIMESTAMP       NOT NULL  DEFAULT CURRENT_TIMESTAMP,
  finishTime   TIMESTAMP       NULL      DEFAULT NULL,
  callbackTime TIMESTAMP       NULL      DEFAULT NULL,
  status       TINYINT UNSIGNED,
  PRIMARY KEY (id),
  UNIQUE INDEX uk_request_sn(sn) USING BTREE
)
  COMMENT '请求指令'
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

