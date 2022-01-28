from pymysql import connect
from pymysql.cursors import DictCursor


class MySQLConnection:
    def __init__(self):
        # initialisation connection
        self.connection = connect(host='localhost',
                                  user='user',
                                  password='user',
                                  db='test',
                                  charset='utf8',
                                  cursorclass=DictCursor)

    def mysql_insert(self, number, content):
        # insert into table number and content
        try:
            with self.connection.cursor() as cursor:
                sql = "insert into questions values(0, " + str(number) + ", '" + content + "')"
                cursor.execute(sql)
            self.connection.commit()
        finally:
            return 'inserting number=' + str(number) + ' is ok'

    def mysql_update(self, number, content):
        # update in table content by key number
        try:
            with self.connection.cursor() as cursor:
                sql = "update questions set content = '" + content + "' where number = " + str(number)
                cursor.execute(sql)
            self.connection.commit()
        finally:
            return 'updating number=' + str(number) + ' is ok'

    def mysql_select(self):
        # getting data from table
        try:
            with self.connection.cursor() as cursor:
                sql = "select * from questions"
                cursor.execute(sql)
            rows = cursor.fetchall()
        finally:
            return rows

    def mysql_close_connection(self):
        # close connection
        self.connection.close()
        return 'connection correctly closed'


def work_with_mysql():
    """
    structure mysql test table:
    CREATE TABLE `questions` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `number` int(11) DEFAULT NULL,
    `content` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
    """
    db = MySQLConnection()
    print(db.mysql_insert(1, 'aaaaaaaa'))
    print(db.mysql_insert(2, 'bbbbbbbb'))
    print(db.mysql_update(1, 'cccccccc'))
    print('Table data:')
    for row in db.mysql_select():
        print(row['number'], row['content'])
    print(db.mysql_close_connection())


def main():
    work_with_mysql()


if __name__ == '__main__':
    main()
