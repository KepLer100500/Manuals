from ultralytics import YOLO
import cv2

# Загружаем модель
model = YOLO('l2.pt')

# Делаем предсказание
results = model('screenshot_2025-10-31_12-18-29.png')

# Загружаем изображение
image = cv2.imread('screenshot_2025-10-31_12-18-29.png')

# Выводим имена классов
print("Классы модели:", model.names)
print("######################")

# Рисуем bounding boxes и текст
for result in results:
    for box in result.boxes:
        class_id = int(box.cls[0])
        conf = box.conf[0]
        x1, y1, x2, y2 = map(int, box.xyxy[0])

        # Определяем цвет и метку
        if class_id == 1:
            label = f"Liendric Lad {conf:.2f}"
            color = (0, 255, 0)  # зелёный
        elif class_id == 0:
            label = f"Liendric {conf:.2f}"
            color = (0, 0, 255)  # красный

        # Рисуем прямоугольник
        cv2.rectangle(image, (x1, y1), (x2, y2), color, 2)

        # Рисуем текст
        cv2.putText(image, label, (x1, y1 - 10),
                    cv2.FONT_HERSHEY_SIMPLEX, 0.6, color, 2)

        # Выводим в консоль
        print(f"Найден {label}")

print("######################")

for result in results:
    for box in result.boxes:
        class_id = int(box.cls[0])
        conf = box.conf[0]
        x1, y1, x2, y2 = map(int, box.xyxy[0])
        print(f"Класс {class_id}, уверенность {conf:.2f}, координаты ({x1}, {y1}) -> ({x2}, {y2})")

print("######################")
print("Результаты визуализированы. Нажмите любую клавишу, чтобы закрыть окно.")

# Показываем изображение
cv2.imshow("Detection Results", image)
cv2.waitKey(0)
cv2.destroyAllWindows()

# Сохраняем результат (опционально)
cv2.imwrite("result_with_boxes.png", image)