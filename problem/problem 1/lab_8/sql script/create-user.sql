drop user if exists 'hbstudent'@'localhost';

Create user 'hbstudent'@'localhost' identified by 'hbstudent';

grant all privileges on * . * to 'hbstudent'@'localhost';