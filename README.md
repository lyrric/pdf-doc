# pdf-doc
根绝模板生成doc，html生成pdf   
# doc生成逻辑   
doc编辑后，保存为xml格式，然后编辑插入thymeleaf标签   
然后使用thymeleaf渲染生成doc  
 note: 无论是用thymeleaf还是freemarker，将xml转成doc都会存在缺陷。  
 用freemarker的话，xml中插入freemarker的标签（循环，if等标签）会导致原始文档不可预览，如果要修改、浏览原始文档，需要将xml里面循环、判断标签删除，修改好后，再加上去，工作量相当的大。  
   用thymeleaf的话，虽然原始xml文档可以直接预览，但是如果修改了内容，会导致thymeleaf的标签全部丢失，届时需要重新插入标签，也是相当复杂。
 两者共同的缺陷都是如果，原始文档有改动，
# doc模板   
![生成前](https://github.com/lyrric/pdf-doc/blob/master/images/doc-generator-before.png?raw=true "生成前")   
# doc生成后   
![生成后](https://github.com/lyrric/pdf-doc/blob/master/images/doc-generator-after.png?raw=true "生成后")
