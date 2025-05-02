package com.inxtwilliqm.newsapp.utils;

import com.inxtwilliqm.newsapp.R;
import com.inxtwilliqm.newsapp.models.News;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NewsData {
    private static final String[] CATEGORIES = {"Technology", "Sports", "Health", "Business"};
    private static final Random random = new Random();

    public static List<News> getAllNews() {
        List<News> allNews = new ArrayList<>();

        // Technology News
        allNews.add(new News(
                "Apple Announces New iPhone 15",
                "The iPhone 15 features a new 48MP main camera with advanced computational photography, " +
                        "a brighter Super Retina XDR display, and the powerful A16 Bionic chip. Battery life has been " +
                        "improved by up to 20% compared to previous models. The device also introduces Dynamic Island, " +
                        "a new way to interact with notifications and live activities.",
                "Technology",
                R.drawable.apple
        ));

        allNews.add(new News(
                "Google Releases Android 14 Beta",
                "Android 14 introduces new privacy controls including photo picker for selective media sharing, " +
                        "improved notification permissions, and more detailed location access controls. Performance " +
                        "enhancements include better memory management and smoother animations. The update also brings " +
                        "customizable lock screens and improved tablet/large-screen support.",
                "Technology",
                R.drawable.google
        ));

        allNews.add(new News(
                "Tesla's New Self-Driving Update",
                "Tesla's Full Self-Driving Beta v11.4 introduces improved object detection, better decision-making " +
                        "at complex intersections, and enhanced smoothness during lane changes. The update also includes " +
                        "new safety features like improved emergency vehicle detection and more conservative behavior " +
                        "in construction zones. Over 100,000 Tesla owners now have access to this advanced autonomous " +
                        "driving technology.",
                "Technology",
                R.drawable.tesla
        ));

        // Sports News
        allNews.add(new News(
                "World Cup 2026 Host Cities Announced",
                "The 2026 FIFA World Cup will be held across 16 cities in the United States, Canada, and Mexico. " +
                        "Notable selections include New York/New Jersey, Los Angeles, Mexico City, and Toronto. This will " +
                        "be the first World Cup with 48 teams participating, up from 32. The tournament is expected to " +
                        "generate over $5 billion in economic impact across the host nations.",
                "Sports",
                R.drawable.fifa
        ));

        allNews.add(new News(
                "NBA Finals: Lakers vs Celtics",
                "The Los Angeles Lakers and Boston Celtics, with 17 championships each, meet in the Finals for " +
                        "the first time since 2010. The series features star players from both teams, including LeBron " +
                        "James and Jayson Tatum. Basketball analysts predict this could be one of the most-watched Finals " +
                        "in history, reviving one of the NBA's greatest rivalries with a new generation of players.",
                "Sports",
                R.drawable.nba
        ));

        allNews.add(new News(
                "Olympic Committee Announces New Sports",
                "The International Olympic Committee has confirmed breakdancing (breaking) will make its Olympic " +
                        "debut in Paris 2024, along with the return of skateboarding. These urban sports are part of " +
                        "the IOC's strategy to attract younger audiences. The breaking competition will feature 16 B-Boys " +
                        "and 16 B-Girls battling in one-on-one matches judged on creativity, personality, technique, " +
                        "and musicality.",
                "Sports",
                R.drawable.olympics
        ));

        // Health News
        allNews.add(new News(
                "Breakthrough in Cancer Research",
                "Researchers at the National Cancer Institute have developed a novel immunotherapy approach that " +
                        "combines checkpoint inhibitors with personalized cancer vaccines. In Phase 1 trials, 65% of " +
                        "patients with advanced melanoma showed complete tumor regression. The treatment works by " +
                        "training the immune system to recognize and attack cancer-specific mutations unique to each " +
                        "patient's tumor.",
                "Health",
                R.drawable.cancer
        ));

        allNews.add(new News(
                "New Study on Mediterranean Diet Benefits",
                "A 10-year study involving over 30,000 participants found those strictly following a Mediterranean " +
                        "diet had a 30% lower risk of cardiovascular events. The diet, rich in olive oil, nuts, fish, " +
                        "and vegetables, was shown to reduce inflammation and improve cholesterol levels. Researchers " +
                        "noted the benefits were most pronounced when combined with regular physical activity and " +
                        "moderate red wine consumption.",
                "Health",
                R.drawable.mediterranean
        ));

        allNews.add(new News(
                "WHO Warns About New Virus Strain",
                "The World Health Organization has classified a new Omicron subvariant, XBB.1.16, as a variant " +
                        "of interest due to its rapid spread in multiple countries. Early data suggests it may be 20% " +
                        "more transmissible than previous strains but doesn't appear to cause more severe disease. " +
                        "Health authorities recommend booster shots for vulnerable populations and continued surveillance " +
                        "as scientists study the variant's characteristics.",
                "Health",
                R.drawable.virus
        ));

        // Business News
        allNews.add(new News(
                "Federal Reserve Raises Interest Rates",
                "The Federal Reserve raised its benchmark interest rate by 0.25 percentage points, bringing the " +
                        "target range to 5%-5.25%, the highest level since 2007. This marks the 10th consecutive rate " +
                        "hike as the central bank continues its fight against inflation. Fed Chair Jerome Powell signaled " +
                        "this might be the last increase for now, as inflation shows signs of moderating while economic " +
                        "growth slows.",
                "Business",
                R.drawable.federalreverse
        ));

        allNews.add(new News(
                "Major Tech Company Layoffs",
                "Several major tech companies including Amazon, Google, and Microsoft have announced significant " +
                        "layoffs totaling over 10,000 positions worldwide. The cuts primarily affect recruiting, HR, and " +
                        "some engineering teams as companies adjust to slowing growth after pandemic-era expansion. " +
                        "Analysts suggest this reflects a broader industry correction rather than fundamental weakness, " +
                        "with companies focusing on profitability over growth.",
                "Business",
                R.drawable.majorlayoffs
        ));

        allNews.add(new News(
                "Cryptocurrency Market Rebounds",
                "Cryptocurrency prices have rebounded strongly, with Bitcoin gaining 20% this week after U.S. " +
                        "regulators provided clearer guidelines for digital asset securities. The SEC's new framework " +
                        "helps distinguish between securities and commodities in the crypto space. Ethereum and other " +
                        "major altcoins also saw significant gains as institutional investors return to the market, " +
                        "with trading volumes reaching their highest levels in six months.",
                "Business",
                R.drawable.crypto
        ));

        return allNews;
    }

    public static List<News> getRandomNews() {
        List<News> topStories = new ArrayList<>();
        List<String> categories = new ArrayList<>(Arrays.asList(CATEGORIES));
        Collections.shuffle(categories); // Randomize category order

        // Get one random news from each category
        for (String category : categories) {
            List<News> categoryNews = getNewsByCategory(category);
            if (!categoryNews.isEmpty()) {
                topStories.add(categoryNews.get(random.nextInt(categoryNews.size())));
            }
        }

        return topStories;
    }

    public static List<News> getNewsByCategory(String category) {
        List<News> filteredNews = new ArrayList<>();
        for (News news : getAllNews()) {
            if (news.getCategory().equals(category)) {
                filteredNews.add(news);
            }
        }
        return filteredNews;
    }
}