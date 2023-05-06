package com.example.kotlin



/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022-12-28 11:50
 * Description:
 *
 */

fun main() {
    mainArray()

}

class Test {

    // 可以改，可以读  get  set
    var info1: String = "A"

    // 只能读， 只有 get
    val info2: String = "B"
}
// TODO Var 与 Val
fun varVal(){
    // 可变变量定义：var 关键字
    // var <标识符> : <类型> = <初始化值>

    // 不可变变量定义：val 关键字，只能赋值一次的变量(有一点点类似Java中final修饰的变量)
    // val <标识符> : <类型> = <初始化值>

    // 可以修改的
    var name: String = "Derry"
    name = "张三"
    name = "李四"

    var info1 = "AAAA" // 类型推到
    var info2 = 'A' // 类型推到  Char
    var info3: Int = 99 // 类型推到  Int

    // 不可以修改的
    val age: Int = 99
    // age = "" 报错


    // 静态语言 编译期 就决定了 String类型
    var info4 = "LISI"  // info4==String类型
    // info4 = 88   // js 动态解释语言
    println("name:$name,  age:$age,  sex:$age  info:$age")
}



// TODO 数组
fun mainArray() {
    // 第一种形式
    val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    // println(numbers[0])
    // println(numbers[7])
    for (number in numbers) {
        // println(number)
    }

    // 第二种形式  value=0
    // 0 + 200 = 200
    // 1 + 200 = 201
    val numbers2 = Array(10) { value: Int -> (value + 200) }
    for (value in numbers2) {
        println(value)
    }

    // 定义一个变量 value Int类型
    // value=0 + 200
    // {value: Int                ->                     (value + 200) }
}