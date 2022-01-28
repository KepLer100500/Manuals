from psycopg2 import connect, sql
from psycopg2.extras import DictCursor
from contextlib import closing


class PG:
    def __init__(self):
        self.dbname = 'test_db'
        self.user = 'user'
        self.password = 'password'
        self.host = '127.0.0.1'


    def open_conn(self):
        conn = connect(dbname=self.dbname, 
                       user=self.user, 
                       password=self.password, 
                       host=self.host)
        return conn

    
    def close_conn(self, conn):
        conn.close()


    def select_data(self):
        with closing(self.open_conn()) as conn:
            with conn.cursor(cursor_factory=DictCursor) as cursor:
                cursor.execute('SELECT * FROM public.test_table')
                for row in cursor:
                    print(row['filed1'], row['filed2'], row['filed3'])


    def insert_data(self):
        data = [
            ('qwerty1', 'name111', 'othername111'), 
            ('qwerty2', 'name222', 'othername222'), 
            ('qwerty3', 'name333', 'othername333'), 
        ]
        conn = self.open_conn()
        with conn.cursor() as cursor:
            conn.autocommit = True
            insert_sql = sql.SQL('INSERT INTO public.test_table (filed1, filed2, filed3) VALUES {}').format(
                sql.SQL(',').join(map(sql.Literal, data))) # Literal - value hardcoded into query
            cursor.execute(insert_sql)
        self.close_conn(conn)


    def update_data(self):
        table_name = 'test_table'
        field_name = 'filed1'
        old_value = 'qwerty1'
        new_value = '500'
        conn = self.open_conn()
        with conn.cursor() as cursor:
            conn.autocommit = True
            update_sql = sql.SQL('UPDATE public.{} SET {} = {} WHERE {} = {}').format(
                sql.Identifier(table_name), 
                sql.Identifier(field_name), 
                sql.Literal(new_value),
                sql.Identifier(field_name),
                sql.Literal(old_value)
                ) # Identifier - dot-separated sequence of identifiers
            cursor.execute(update_sql)
        self.close_conn(conn)


def main():
    pg = PG()
    pg.insert_data()
    pg.update_data()
    pg.select_data()


if __name__ == "__main__":
    main()