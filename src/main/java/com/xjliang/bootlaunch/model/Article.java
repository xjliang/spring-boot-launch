package com.xjliang.bootlaunch.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {

    /**
     * id : 1
     * author : xjliang
     * title : spring boot study
     * content : c
     * createTime :
     * reader : [{"name":"xjliang","age":18},{"name":"kobe","age":37}]
     */

    private Long id;
    private String author;
    private String title;
    private String content;
    private String createTime;
    private List<ReaderBean> reader;

    public static class ReaderBean {

        /**
         * name : xjliang
         * age : 18
         */

        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
