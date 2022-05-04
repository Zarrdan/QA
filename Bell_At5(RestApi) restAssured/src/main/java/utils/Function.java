package utils;

import dto.ResourceInfoData;
import dto.UserDataResponse;

import java.util.*;

public class Function {

    /**
     * ������ ����� ��������� url �������� � ���� ������ (responce), ����� ������ ����������� �� \n,
     * ����� ������������ �  ����� ����, ��� ����� �������� ����� ('/')
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
     * ������ ����� ��������� List ��� ������� ��������� ������ �������,
     * ����� � ����� � ������� ������� ����������� ������ � ������������ � ����� List
     */
    public static List<String> getOnlyAvatar(List<UserDataResponse> usersAvatars) {
        List<String> onlyAvatar = new ArrayList<>();
        for (UserDataResponse newset : usersAvatars) {
            onlyAvatar.add(newset.getAvatar());
        }
        return onlyAvatar;

    }

    /**
     * ������ ����� ��������� List ��� ������� ��������� ������ �������,
     * ����� � ����� � ������� ������� ����������� ������ � ������������ � ����� Set
     * (������������ ������ ���������� �������)
     */
    public static Set<String> getUniqieAvatar(List<UserDataResponse> usersAvatars) {
        Set<String> uniqie = new LinkedHashSet<>();
        for (UserDataResponse newset : usersAvatars) {
            uniqie.add(newset.getAvatar());
        }
        return uniqie;
    }

    /**
     * ������ ����� ��������� List ��� ������� ��������� ������ �������,
     * ����� � ����� � ������� ������� ����������� ��� � ������������ � ����� List
     */
    public static List<Integer> getActualYear(List<ResourceInfoData> years) {
        List<Integer> actualYears = new ArrayList<>();
        for (ResourceInfoData newset : years) {
            actualYears.add(newset.getYear());
        }
        return actualYears;

    }

    /**
     * ������ ����� ��������� List ��� ������� ��������� ������ �������,
     * ����� � ����� � ������� ������� ����������� ��� � ������������ � ����� List,
     * ���������� List ����������� �� �����������
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
