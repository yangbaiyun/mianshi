package util;


import model.Person;

import java.util.*;
import java.util.regex.Pattern;

/**
 *
 * PersonList排序工具类
 * 注：测试类在test文件夹下
 */
public class PersonListSortUtil {


    /**
     * 把sortKeyWords给定的职位顺序 重新排序到personList首部，
     * 不支持模糊匹配;
     * 该方法适合处理数据量小的情况.
     *
     * @param personList 员工列表
     * @param sortKeyWords 排序职位名称数组
     */
    public static void sortPersonListByTitle(List<Person> personList, String[] sortKeyWords)
    {

        if(personList==null || personList.size() == 0)
            return;


        //借鉴选择排序, 把sortKeyWords中匹配的职位排在前面

        int index = 0;//找到符合条件的person后放入personList.get(index)内,然后index++

        for(String sortWord:sortKeyWords)
        {

            String pattern = ".*[,]?"+sortWord+"[,]?.*";//职位匹配模式
            for(int i = 0;i < personList.size();i++)
            {

                Person person = personList.get(i);
                if(person.getTitle() == null || person.getTitle().equals(""))
                    continue;

                //如果匹配该职位名称 则personList.get(index)与当前personList.get(i) 交换
                if(Pattern.matches(pattern, person.getTitle()))
                {
                    personList.set(i,personList.get(index));
                    personList.set(index++,person);
                }

            }
        }
    }






}
