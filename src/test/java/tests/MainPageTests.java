package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import java.util.Arrays;
import java.util.List;

@Epic("UI сайта IBS.ru")
@Feature("Главная страница")
@DisplayName("Сценарии проверок главной страницы")
public class MainPageTests extends TestBase {
    MainPage mainPage = new MainPage();
    String
            ruDescription = "Ключевой технологический партнер лидеров российского бизнеса",
            engDescription = "A key technology partner for Russian business leaders",
            popularSearchHeaderName = "Популярные запросы",
            lastSearchHeaderName = "Недавние запросы",
            englishShort = "Eng",
            russianShort = "Ru",
            searchString = "Вакансии";
    List<String> sectionList = Arrays.asList("Решения и услуги", "Отраслевые решения", "Проекты", "Создано в IBS", "Карьера", "Медиацентр", "О компании");

    @Test
    @DisplayName("Проверка смены языка")
    @Severity(SeverityLevel.NORMAL)
    @Owner("AleksSh")
    void languageSwitchTest() {
        mainPage
                .openPage()
                .checkTopSlideDescription(ruDescription)
                .switchLang(englishShort)
                .checkTopSlideDescription(engDescription)
                .switchLang(russianShort)
                .checkTopSlideDescription(ruDescription);
    }

    @Test
    @DisplayName("Проверка текста в элементах раздела поиска по сайту")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("AleksSh")
    void searchPopularHeaderTest() {
        mainPage
                .openPage()
                .clickSearch()
                .checkSearchPlaceholder()
                .checkSearchHeader(popularSearchHeaderName)
                .checkSearchHeader(lastSearchHeaderName);
    }

    @Test
    @DisplayName("Проверка поиска по сайту")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("AleksSh")
    void searchTest() {
        mainPage
                .openPage()
                .clickSearch()
                .performSearch(searchString)
                .checkSearchResultsAreVisible()
                .checkSearchTabsAreVisible();
    }

    @Test
    @DisplayName("Проверка названий разделов гамбургер-меню")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("AleksSh")
    void searchNavigationSectionTest() {
        mainPage
                .openPage()
                .clickHamburger();
        for (String sectionName : sectionList) {
            mainPage.checkNavigationSectionString(sectionName);
        }
    }

}