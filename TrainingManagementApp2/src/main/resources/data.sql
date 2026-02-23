INSERT INTO roles (code, "value")
VALUES
(1, 'ADMIN'),
(2, 'GENERAL');


INSERT INTO users (id, role_code, name, password, email)
VALUES
(1, 1, '管理者太郎', '$2a$10$/D6s7mzc34Bqm2ycuCDsj.W9fh8APyhju7EdL6RxzbNvFUIT4oO3C', 'admin@mail.com'),
(2, 2, '一般二郎', '$2a$10$/D6s7mzc34Bqm2ycuCDsj.W9fh8APyhju7EdL6RxzbNvFUIT4oO3C', 'user@mail.com');
--passはいずれも"password"
--usersテーブル定義の変更、user_idカラムの変更、自動採番3から
ALTER TABLE users ALTER COLUMN id RESTART WITH 3;


INSERT INTO physical_details (user_id, created_at, weight, recorded_date)
VALUES
(1, '2026-02-06 22:49:01', 89.5, '2026-02-06'),
(1, '2026-02-07 22:49:01', 89.5, '2026-02-07'),
(1, '2026-02-08 22:49:01', 89.5, '2026-02-08'),
(1, '2026-02-09 22:49:01', 89.5, '2026-02-09'),
(1, '2026-02-10 22:49:01', 89.5, '2026-02-10'),
(1, '2026-02-11 22:49:01', 89.5, '2026-02-11'),
(1, '2026-02-12 22:49:01', 89.5, '2026-02-12'),
(1, '2026-02-13 22:49:01', 89.5, '2026-02-13'),
(2, '2026-02-14 22:50:05', 48.5, '2026-02-06');



