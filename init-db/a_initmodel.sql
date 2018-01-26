USE wbuiyx_baptiste;
CREATE TABLE lvl (
  id INT,
  number INT UNIQUE,
  width INT,
  height INT,
  PRIMARY KEY (id)
);

CREATE TABLE element (
  id INT,
  `type` VARCHAR(255),
  `level` INT,
  x INT,
  y INT,
  direction VARCHAR(255) NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (`level`) REFERENCES lvl(id)
)