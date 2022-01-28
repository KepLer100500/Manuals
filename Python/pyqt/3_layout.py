import sys
from PyQt5.QtWidgets import QWidget, QGridLayout, QPushButton, QApplication, QLabel, QLineEdit, QTextEdit


class MainWindow(QWidget):
    def __init__(self):
        super().__init__()
        self.initUI()

    def initUI(self):
        grid = QGridLayout() # Создание сеточный макет
        grid.setSpacing(10) # Установка промежутков между объектами внутри сетки
        self.setLayout(grid) # Привязка сетки к окну

        names = ['Clear', 'Back', '', 'Close',
                 '7', '8', '9', '/', 
                 '4', '5', '6', '*', 
                 '1', '2', '3', '-', 
                 '0', '.', '=', '+',
                 ] # Формирование списка имён
        positions = [(i, j) for i in range(5) for j in range(4)] # Формирование списка координат

        for position, name in zip(positions, names): # Собрать (сцепить) в одиг список позиции и имена кнопок и перебрать их
            if name == '':
                continue
            button = QPushButton(name) # Создаём кнопку с таким именем
            grid.addWidget(button, *position) # Перемещаем кнопку в заданную позицию

        title = QLabel('Название') # Label
        author = QLabel('Автор') # Label
        review = QLabel('Обзор') # Label

        titleEdit = QLineEdit() # Однострочное текстовое поле
        authorEdit = QLineEdit() # Однострочное текстовое поле
        reviewEdit = QTextEdit() # Многострочное текстовое поле

        grid.addWidget(title, 5, 0) # Привязка объектов к сетке
        grid.addWidget(titleEdit, 5, 1)
        grid.addWidget(author, 6, 0)
        grid.addWidget(authorEdit, 6, 1)
        grid.addWidget(review, 7, 0)
        grid.addWidget(reviewEdit, 7, 1, 8, 3) # Растяжение объекта на несколько ячеек сетки от 7,1 до 8,3

        self.setGeometry(500, 400, 300, 200)
        self.setWindowTitle('Калькулятор')
        self.show()


def main():
    app = QApplication(sys.argv)
    window = MainWindow()
    sys.exit(app.exec_())

if __name__ == "__main__":
    main()