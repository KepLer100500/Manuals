import sys
from PyQt5.QtWidgets import QApplication, QWidget, QPushButton, QToolTip, QMessageBox, QDesktopWidget
from PyQt5.QtGui import QIcon, QFont
from PyQt5.QtCore import QCoreApplication


class MainForm(QWidget):
    def __init__(self):
        super().__init__() # Вызов конструкторов родительских классов
        self.initUI() # Функция создания окна

    def initUI(self):
        QToolTip.setFont(QFont('SansSerif', 10)) # Шрифт для всплывающих подсказок
        btn = QPushButton('Быстрый выход', self) # Создать кнопку с подписью Закрыть
        btn.setToolTip('Эта кнопка сразу <b>о_О</b> закрывает!') # Всплывающее окно - подсказка для кнопки
        btn.resize(btn.sizeHint()) # Задать кнопке рекомендуюемые размеры
        btn.move(50, 50) # Переместить кнопку
        btn.clicked.connect(QCoreApplication.instance().quit) # закрыть окно
        #self.resize(250, 150) # Задать размер
        #self.move(300, 300) # Задать позицию
        self.setGeometry(500, 400, 300, 200) # 500, 400 - координаты создания, 300х200 - размер 
        self.setWindowTitle('Главное окно') # Title
        self.setWindowIcon(QIcon('resources/1.ico')) # Иконка
        self.center() # Перемещает окно по центру экрана
        self.show() # Показать виджет

    def closeEvent(self, event):
        reply = QMessageBox.question(self, 'Сообщение', 'Точно выйти?', QMessageBox.Yes | QMessageBox.No, QMessageBox.No) # Диаологовое окно Да/Нет, фокус на Нет
        if reply == QMessageBox.Yes:
            event.accept() # Если да, то подтвердить событие 
        else:
            event.ignore() # Если нет, то игнорировать

    def center(self):
        window = self.frameGeometry() # Текущая конфигурация геометрии окна
        monitor = QDesktopWidget().availableGeometry().center() # Центральная точка экрана монитора
        window.moveCenter(monitor) # Установка центра окна по центру экрана
        self.move(window.topLeft()) # Перемещение в центр экрана окна


def main():
    app = QApplication(sys.argv) # Объект класса Приложение с параметрами argv
    mf = MainForm() # Объект класса наше окно
    sys.exit(app.exec_()) # Основной цикл до выхода

if __name__ == "__main__":
    main()