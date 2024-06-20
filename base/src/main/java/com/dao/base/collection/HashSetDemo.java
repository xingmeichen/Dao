package com.dao.base.collection;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @project: Dao
 * @description:
 * 这个类展示HashSet的特性
 * 1. Set中的元素不能重复，被放到Set中的元素如果它们的 hashCode相等，则被视为同一个元素
 *    而如果hashCode不想等，即使equals 相等，也会被认为是不同的元素.
 *    所以如果想用通过Set对元素去重，一定要记得同时重写hashCode() 和 equals(Object obj)方法
 * 2. 如果Set中已经存在一个元素，尝试添加（add）相同的元素将会失败（但是不会报错），
 *    所以如果尝试添加相同的元素，Set中只存在首次添加的元素
 *    Set中的元素其实是以Map<K, V>的形式存在的，所以, K的值就是Set中的元素，V 是一个Object
 * 3.
 *
 * @author: Mabel.Chen
 * @create: 2024-06-20
 **/
public class HashSetDemo {

    public static void main(String[] args) {
        Set<SetDomain1> set1 = new HashSet<>();
        SetDomain1 domain1 = new SetDomain1(1l, "domain1");
        SetDomain1 domain11 = new SetDomain1(1l, "domain1");
        set1.add(domain1);
        set1.add(domain11); // add into set1 succeed
        System.out.println(set1.size()); // 2
        System.out.println("----------------");

        Set<SetDomain2> set2 = new HashSet<>();
        SetDomain2 domain2 = new SetDomain2(2l, "domain2", "role2");
        SetDomain2 domain22 = new SetDomain2(2l, "domain2", "role22");
        set2.add(domain2);
        set2.add(domain22); // add into set2 failed
        System.out.println(set2.size()); // 1
        System.out.println(set2.contains(domain2)); // true
        System.out.println(set2.contains(domain22)); // true, 易错, 因为重写了equals 和 hashCode, domain2 和 domain22 是等价的
        set2.forEach(item -> System.out.println(item.getRole())); // role2
        System.out.println(domain2 == domain22); // false, 易错，注意：两个对象==的结果是true, 表示它们指向同一个内存地址空间，
        // 所以即使是 equals 和 hashCode 都一样的两个对象，它们也不一定是指向同一个内存地址空间
        System.out.println("----------------");

        Set<SetDomain3> set3 = new HashSet<>();
        SetDomain3 domain3 = new SetDomain3(3l, "domain3");
        SetDomain3 domain33 = new SetDomain3(33l, "domain33");
        set3.add(domain3);
        set3.add(domain33);
        System.out.println(set3.size()); // 2
        System.out.println(set3.contains(domain3)); // true
        System.out.println(set3.contains(domain33)); // true
    }
}

/***
 * only override equals()
 */
class SetDomain1 {
    private long id;
    private String name;

    public SetDomain1(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        SetDomain1 domain1 = (SetDomain1) obj;
        return Objects.equals(this.id, domain1.id) && Objects.equals(this.name, domain1.name);
    }
}

/***
 * override equals() & hashCode()
 */
class SetDomain2 {
    private long id;
    private String name;
    private String role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public SetDomain2(long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        SetDomain2 domain2 = (SetDomain2) obj;
        return Objects.equals(this.id, domain2.id) && Objects.equals(this.name, domain2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }
}

class SetDomain3 {
    private long id;
    private String name;

    public SetDomain3(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}