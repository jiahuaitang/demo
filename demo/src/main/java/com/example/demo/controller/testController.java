package com.example.demo.controller;

import com.example.demo.annotation.NotControllerResponseAdvice;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("test")
public class testController {

    @GetMapping("sayHello")
    @NotControllerResponseAdvice
    public String sayHello(){
        return "hello!";
    }


    public static void main(String[] args) {

        Entity[] entities = new Entity[10000];
        for(int i=0;i<entities.length;i++){
            String age = "男";
            if (i%2==1){
                age = "女";
            }
            entities[i] = new Entity(Long.valueOf(i),"entity"+i,age);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Entity> list = Arrays.asList(entities);
        StopWatch sw = new StopWatch();
        sw.start("开始");
        List<Entity> collect = list.parallelStream().filter(e -> e.getId() % 2 == 0).collect(Collectors.toList());
        sw.stop();
        System.out.println(sw.prettyPrint());
        System.out.println(sw.getTotalTimeMillis()+"");
        //System.out.println(sw.getTaskInfo());
        System.out.println(collect);

    }


}

class Entity{
    private Long id;
    private String name;
    private String age;

    public Entity(Long id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
