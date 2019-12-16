### 案例数据表SQL

```sql
CREATE TABLE girl (
	id INT auto_increment PRIMARY KEY,
	name VARCHAR ( 12 ) NOT NULL,
	age INT NULL,
	birthday date NULL,
	cup VARCHAR ( 10 ) NULL,
	leg VARCHAR ( 10 ) NULL,
	phone VARCHAR ( 16 ) NULL,
	address VARCHAR ( 60 ) NULL,
    status enum ( 'Y', 'N' ) DEFAULT 'Y' NULL 
);
```