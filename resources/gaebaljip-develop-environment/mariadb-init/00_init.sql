CREATE
    USER 'gaebaljip-dev'@'localhost' IDENTIFIED BY 'gaebaljip-dev';
CREATE
    USER 'gaebaljip-dev'@'%' IDENTIFIED BY 'gaebaljip-dev';

GRANT ALL PRIVILEGES ON *.* TO
    'gaebaljip-dev'@'localhost';
GRANT ALL PRIVILEGES ON *.* TO
    'gaebaljip-dev'@'%';

CREATE
    DATABASE gaebaljip DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
