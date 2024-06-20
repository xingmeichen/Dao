package com.dao.base.bottom;

import org.openjdk.jol.vm.VM;
import org.openjdk.jol.vm.VirtualMachine;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-20
 **/
public class VMDemo {

    public static void main(String[] args) {
        VirtualMachine virtualMachine = VM.current();
        System.out.println(virtualMachine.details());
    }
}