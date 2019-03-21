# wallstreetcn-news-forex

使用框架：
springboot+mybatis+quartz+pagehelper+webmagic+mysql

项目流程：
1，通过webmagic对网站进行数据抓取，并将数据直接存储在mysql中。
2，使用quartz对爬虫程序进行定时执行。
3，提供json格式的接口查询数据，并通过pagehelper进行分页查询


