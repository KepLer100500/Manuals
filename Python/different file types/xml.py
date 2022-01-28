from lxml import etree


def write_to_file(file_name):
    html = etree.Element('html')            # Создание корневого элемента html
    head = etree.SubElement(html, 'head')   # Добавление дочернего элемента к html
    body = etree.SubElement(html, 'body')

    title = etree.SubElement(head, 'title')  # Добавление дочернего элемента к head
    title.text = 'Site title'                # Задать текст тегу
    link = etree.SubElement(head, 'link', rel='stylesheet',
                            href='styles.css', type='text/css')  # Задать свойства тегу

    print(etree.tostring(html, pretty_print=True).decode('utf-8'))                    # Красивый вывод на печать
    tree = etree.ElementTree(html)                                                    # Обозначить корневой элемент
    tree.write(file_name, pretty_print=True, xml_declaration=True, encoding='utf-8')  # Записать файл


def read_file(file_name):
    tree = etree.parse(file_name)
    nodes = tree.xpath('/html/head/link')                # Доступ напрямую к тегу
    for node in nodes:
        print(node.tag, node.keys(), node.values())      # Название тега, список свойств и список значений
        print('rel =', node.get('rel'))                  # Доступ к свойствам тега

    nodes = tree.xpath('/html/head/title')               # Доступ напрямую к тегу
    for node in nodes:
        print('title =', node.text)                      # Доступ к тексту тега

    print(tree.xpath('/html/head/link')[0].get('type'))  # Доступ напрямую к тегу

    for node in tree.iterfind('.//link'):                # Поиск тега
        print(node.get('href'))


def main():
    file_name = 'test.xml'
    write_to_file(file_name)
    read_file(file_name)


if __name__ == "__main__":
    main()
