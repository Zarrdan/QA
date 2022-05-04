package utils;

import dto.ResourceInfoData;
import dto.UserDataResponse;

import java.util.*;

public class Function {

    /**
     * Данный метод принимает url страницу в виде стринг (responce), затем строка разделяется по \n,
     * затем записывается в  новый лист, без учета закрытых тэгов ('/')
     */
    public static List<String> makeTagList(String responce) {
        String[] words = responce.split("\n ");
        List<String> tagList = new ArrayList<>();
        for (String s : words) {
            String name = s.trim();
            if (name.charAt(1) != '/') {
                tagList.add(name);
            }
        }
        return tagList;
    }

    /**
     * Данный метод принимает List где указаны различные данные обьекта,
     * затем в цикле у данного объекта извлекается аватар и записывается в новый List
     */
    public static List<String> getOnlyAvatar(List<UserDataResponse> usersAvatars) {
        List<String> onlyAvatar = new ArrayList<>();
        for (UserDataResponse newset : usersAvatars) {
            onlyAvatar.add(newset.getAvatar());
        }
        return onlyAvatar;

    }

    /**
     * Данный метод принимает List где указаны различные данные обьекта,
     * затем в цикле у данного объекта извлекается аватар и записывается в новый Set
     * (записываются только уникальные аватары)
     */
    public static Set<String> getUniqieAvatar(List<UserDataResponse> usersAvatars) {
        Set<String> uniqie = new LinkedHashSet<>();
        for (UserDataResponse newset : usersAvatars) {
            uniqie.add(newset.getAvatar());
        }
        return uniqie;
    }

    /**
     * Данный метод принимает List где указаны различные данные обьекта,
     * затем в цикле у данного объекта извлекается год и записывается в новый List
     */
    public static List<Integer> getActualYear(List<ResourceInfoData> years) {
        List<Integer> actualYears = new ArrayList<>();
        for (ResourceInfoData newset : years) {
            actualYears.add(newset.getYear());
        }
        return actualYears;

    }

    /**
     * Данный метод принимает List где указаны различные данные обьекта,
     * затем в цикле у данного объекта извлекается год и записывается в новый List,
     * полученный List сортируется по возрастанию
     */
    public static List<Integer> getSortedYear(List<ResourceInfoData> years) {
        List<Integer> sortedYears = new ArrayList<>();
        for (ResourceInfoData newset : years) {
            sortedYears.add(newset.getYear());
        }
        Collections.sort(sortedYears);
        return sortedYears;
    }
}
