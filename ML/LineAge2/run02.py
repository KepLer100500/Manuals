from ultralytics import YOLO

model = YOLO('l2.pt')

results = model('screenshot_2025-10-31_12-18-29.png')

print("Классы модели:", model.names)

print("######################")

for result in results:
    for box in result.boxes:
        class_id = int(box.cls[0])
        conf = box.conf[0]
        if class_id == 1:
            print(f"Найден Liendric Lad {conf:.2f}")
        elif class_id == 0:
            print(f"Найден Liendric {conf:.2f}")

print("######################")

for result in results:
    for box in result.boxes:
        class_id = int(box.cls[0])
        conf = box.conf[0]
        x1, y1, x2, y2 = map(int, box.xyxy[0])
        print(f"Класс {class_id}, уверенность {conf:.2f}, координаты ({x1}, {y1}) -> ({x2}, {y2})")