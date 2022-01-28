import sys
from PyQt5.QtWidgets import QMainWindow, QApplication, QAction, qApp
from PyQt5.QtGui import QIcon


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.initUI()

    def initUI(self):
        exitAction = QAction(QIcon('resources/exit.png'), 'Выход', self) # Создание объекта класса меню с привязкой картинки
        exitAction.setShortcut('Ctrl+Q') # Горячая клавиша
        exitAction.setStatusTip('Выход тут!') # Подсказка в строке состояния
        exitAction.triggered.connect(qApp.quit) # Какая функция будет выполняться при выборе пункта меню

        menubar = self.menuBar() # Создание меню
        fileMenu = menubar.addMenu('File') # Добавление в меню пункта "Файл"
        fileMenu.addAction(exitAction) # Добавление в меню Файл пункта "Выход"

        self.toolbar = self.addToolBar('Exit') # Создание тулбара
        self.toolbar.addAction(exitAction) # Привязка к тулбару пункта с событием (функцией) exitAction

        self.statusBar().showMessage('Готов!') # Инициализация статусбара
        self.setGeometry(500, 400, 300, 200) # Позиция и размеры окна
        self.setWindowTitle('Главное окно') # Титул окна
        self.show() # Показать окно


def main():
    app = QApplication(sys.argv)
    window = MainWindow()
    sys.exit(app.exec_())

if __name__ == "__main__":
    main()