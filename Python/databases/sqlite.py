from sqlite3 import connect
from random import randint


class DB:
    def __init__(self, dbName, tableName):
        self.dbName = dbName
        self.tableName = tableName


    def open_DB(self):
        self.conn = connect(self.dbName)
        self.cursor = self.conn.cursor()


    def create_table(self):
        query = '''
                CREATE TABLE IF NOT EXISTS "{}" (
                    "id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                    "name"	TEXT,
                    "price"	REAL
                );
                '''.format(self.tableName)
        self.cursor.execute(query)
        self.conn.commit()


    def backup_data(self):
        backup_con = connect('backup_testDB.db')
        self.conn.backup(backup_con)
        backup_con.close()


    def insert_data(self, data):
        query = 'INSERT INTO {} (name, price) VALUES(?, ?)'.format(self.tableName)
        self.cursor.execute(query, data)
        self.conn.commit()


    def show_data(self):
        query = 'SELECT * FROM {}'.format(self.tableName)
        self.cursor.execute(query)
        for row in self.cursor.fetchall():
            print(row)


    def close_DB(self):
        self.conn.close()


def generate_data():
    random_word = ''.join(chr(randint(ord('a'), ord('z'))) for i in range(10))
    random_num = randint(1, 500)
    return (random_word, random_num)


def main():
    db = DB('testDB.db', 'test_table')
    db.open_DB()
    db.create_table()
    db.backup_data()
    db.insert_data(generate_data())
    db.show_data()
    db.close_DB()


if __name__ == '__main__':
    main()