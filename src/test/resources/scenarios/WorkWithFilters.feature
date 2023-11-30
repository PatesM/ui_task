Feature: Фильтр результатов поиска

  Background: Пользователь находится на главной странице сайта Wildberries
    Given Открываем сайт "https://www.wildberries.ru/"

  Scenario: Применение фильтров на странице поиска товаров
    When Пользователь нажимает на кнопку 'Категории'
    And Наводит курсор мыши на категорию 'Электроника'
    And Нажимает на категорию 'Ноутбуки и компьютеры'
    And Нажимает на категорию 'Ноутбуки'
    Then Открывается страница с заголовком категории ⎼ 'Ноутбуки и ультрабуки'
    When Пользователь нажимает на кнопку 'Все фильтры'
    And Выбирает цену от '100000' до '140000'
    And Выбирает срок доставки 'до 3 дней'
    And Выбирает бренд 'Apple'
    And Выбирает диагональ экрана '13.3"'
    And Нажимает на кнопку 'Показать'
    Then Кол-во товаров на странице равно количеству товаров на странице
    And Первый фильтр на странице 'до 5 дней'
    And Второй фильтр на странице 'Apple'
    And Третий фильтр на странице 'от 100 000 до 140 000'
    And Четвертый фильтр на странице '13.3"'
    And Кнопка 'Сбросить все' доступна для нажатия
    And Закрывает браузер