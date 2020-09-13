package util;

import model.Person;
import org.junit.*;
import java.util.*;

/**
 * personList排序工具类测试
 */
public class PersonListSortUtilTest {



    private List<Person> personList;


    @Before
    public void init()
    {
        personList = new ArrayList<Person>();
        personList.add(new Person("测试工程师"));
        personList.add(new Person("UI"));
        personList.add(new Person("前端工程师"));
        personList.add(new Person("副经理"));
        personList.add(new Person("后端工程师"));
        personList.add(new Person("总经理"));
        personList.add(new Person("运维"));
        personList.add(new Person("项目经理"));
        personList.add(new Person("产品经理"));
    }


    /**
     * 测试排序基本功能
     */
    @Test
    public void sortPersonListByTitle() {

          String[] sortKeyWords = {"总经理","副经理","产品经理"};
          PersonListSortUtil.sortPersonListByTitle(personList,sortKeyWords);

        Assert.assertEquals("测试职位排序基本功能",sortKeyWords[0],personList.get(0).getTitle());
        Assert.assertEquals("测试职位排序基本功能",sortKeyWords[1],personList.get(1).getTitle());
        Assert.assertEquals("测试职位排序基本功能",sortKeyWords[2],personList.get(2).getTitle());
    }


    /**
     * 测试排序 职位为null值
     */
    @Test
    public void testSortPersonListByTitle2() {

        String[] sortKeyWords = {"总经理","副经理","产品经理"};


        personList.add(new Person());
        PersonListSortUtil.sortPersonListByTitle(personList,sortKeyWords);

        Assert.assertEquals("测试职位排序基本功能",sortKeyWords[0],personList.get(0).getTitle());
        Assert.assertEquals("测试职位排序基本功能",sortKeyWords[1],personList.get(1).getTitle());
        Assert.assertEquals("测试职位排序基本功能",sortKeyWords[2],personList.get(2).getTitle());

        Assert.assertEquals("测试职位排序-职位存在null值",null,personList.get(personList.size()-1).getTitle());
    }


    /**
     * 测试排序 职位为""值
     */
    @Test
    public void testSortPersonListByTitle3() {

        String[] sortKeyWords = {"总经理","副经理","产品经理"};

        personList.add(new Person(""));
        PersonListSortUtil.sortPersonListByTitle(personList,sortKeyWords);

        Assert.assertEquals("测试职位排序基本功能",sortKeyWords[0],personList.get(0).getTitle());
        Assert.assertEquals("测试职位排序基本功能",sortKeyWords[1],personList.get(1).getTitle());
        Assert.assertEquals("测试职位排序基本功能",sortKeyWords[2],personList.get(2).getTitle());

        Assert.assertEquals("测试职位排序-职位存在“”值","",personList.get(personList.size()-1).getTitle());
    }


    /**
     * 测试排序 某人有多个职位
     */
    @Test
    public void testSortPersonListByTitle4() {

        String[] sortKeyWords = {"总经理","副经理","产品经理","运维"};

        personList.add(new Person("前端工程师,运维,测试"));
        personList.add(new Person("前端工程师,后端工程师,测试"));
        PersonListSortUtil.sortPersonListByTitle(personList,sortKeyWords);

        Assert.assertEquals("测试职位排序基本功能",sortKeyWords[0],personList.get(0).getTitle());
        Assert.assertEquals("测试职位排序基本功能",sortKeyWords[1],personList.get(1).getTitle());
        Assert.assertEquals("测试职位排序基本功能",sortKeyWords[2],personList.get(2).getTitle());
        Assert.assertEquals("测试职位排序基本功能",sortKeyWords[3],personList.get(3).getTitle());

        Assert.assertNotEquals("测试职位排序-某人有多个职位","前端工程师,运维,测试",personList.get(personList.size()-2).getTitle());
        Assert.assertEquals("测试职位排序-某人有多个职位","前端工程师,后端工程师,测试",personList.get(personList.size()-1).getTitle());
    }


    /**
     * 测试排序 不支持模糊匹配测试
     */
    @Test
    public void testSortPersonListByTitle5() {

        String[] sortKeyWords = {"总经理","副经理"};

        PersonListSortUtil.sortPersonListByTitle(personList,sortKeyWords);

        Assert.assertEquals("测试职位排序基本功能",sortKeyWords[0],personList.get(0).getTitle());
        Assert.assertEquals("测试职位排序基本功能",sortKeyWords[1],personList.get(1).getTitle());
        Assert.assertEquals("测试职位排序-不支持模糊匹配测试","前端工程师",personList.get(2).getTitle());
    }





}