# 前言
>进入21世纪以来，电子商务伴随着IT的成熟，逐渐发展壮大，成为网络经济的核心。在电子商务的发展过程中，人们逐渐意识到在线购物的无地域界限、安全、方便快捷及其价格优势，在线购物的队伍也随之扩大。E-Store网上商城系统是基于Internet 网络平台，利用Web、数据库、Java等技术开发的Web应用系统。 在E-Store设计开发过程中，对系统的不同模块分别采用Spring+Struts2+Hibernate+JSP，能在实现项目的过程中自然地得掌握所用到的技术，提高实际Java Web应用项目的开发技能。

<br>

![]() <br>
![]() <br>
![]() <br>
![]() <br>


### 项目整体操作说明 

    （1）顾客在进行第一次购物之前要进行注册。一般要求输入用户名和
         密码等基本信息。注册完后，系统会显示一个登陆页面； 
    （2）进入网上商店，查看，挑选商品。顾客可以按产品类别检索商品，
         找出所关心的商品；  
    （3）查看商品细节说明，了解价格、付款方式、购物说明 等详细信
         息；
    （4）选中商品后，点击“放入购物车”按钮，将商品放入购物车；如
         需继续购物则点击“继续购物”按钮；  
    （5）选购结束，检查购物车，核实商品和数量是否正确，如有出入，
         可以重新调整商品和数量，如无误，则点击“提交订单”按钮；  
    （6）在结账页面填写自己的相关信息，如姓名，信用账号，电话号码
        等基本信息，完成结账；在验证页面核对结账信息，如无误点击“确
        定”完成提交订单过程，如有误则返回结账页面进行修改；
    （7）在订单页面可以查看订单明细以及进行付款选择，点击“付款”按钮
        后进入支付方式选择页面，选择支付方式进行付款，付款成功后返回订单页面。

<br>

### 功能需求

    1.注册
        在register.jsp页面注册一个新用户，用户名作为以后登陆唯一标识。当注册成功的话，跳转到login.jsp页面

    详细描述：1．需要判断注册的用户名是否已经在数据库中存在。
             2．最后将注册信息保存到Customer表

    具体步骤：1. 实现ICustomerDao接口中的saveCustomer()方法
             2．实现ICustomerService接口中的业务逻辑register()方法
             3．创建RegisterAction.java，在该Action中调用ICustomerService接口中的register()方法进行注册。

    2.登录
      在login.jsp页面上用户可以输入用户名和密码进行登陆，如果用户名和密码都正确，则登陆成功跳转到Index.jsp。如果不正确，需要提示用户并且还是跳转到login.jsp页面继续登陆。
    具体过程： 1．查看登陆的用户名是否存在
              2．查看密码是否正确

    具体步骤：1. 实现ICustomerDao接口中的findCustomerByName()方法
             2．实现ICustomerService接口中的业务逻辑login()方法
             3．创建LoginAction.java，在该Action中调用ICustomerService接口中的login()方法进行登陆。
    3.购物车
      3.1增加orderline
      在listBookStore.jsp中填入图书数量并点击购买按钮后往购物车(ShoppingCart.java)中增加一个Orderline.

      具体步骤： 1) 创建OrderFormAction.java
                2) 在该Action中根据从listBookStore.jsp页面传入的bookid和num来构造一个Orderline对象，然后从Session中获得购物车(ShoppingCart)的对                  象，并且 调用其中的addLine(Orderline orderline)方法往购物车中增加一个Orderline对象。
                3) 增加Orderline成功后跳转到myOrders.jsp页面
      3.2查看购物车
      在listBookStore.jsp页面上点击查看购物车的按钮可以查看购物车中所有Orderline的信息。
      具体步骤：1) 点击查看购物车按钮后链接到shopCar.jsp
               2) 在shopCar.jsp页面中，从Session中取出ShoppingCart对象并且在该页面上输出所有其中的Orderline信息

      3.3删除orderLine
      在listCart.jsp页面中点击清除按钮就可以从购物车中删除一个指定的Orderline。
      具体步骤：1) 创建delOrderline.action		 
               2) 在action中获得shopCar.jsp页面中传递过来的lineid(bookid)。
               3) 从Session中获得ShoppingCart对象，并且调用它的dropLine(Long lineid)方法来删除一个指定的Orderline对象。
               4) 删除成功后跳转到shopCar.jsp页面

      3.4修改orderLine
      在shopCar.jsp页面上修改图书数量并点击修改按钮后可以修改指定一个Orderline的信息。
      具体步骤：1) 创建EditOrderline.action
               2) 在该Action中先从Session中获得ShoppingCart对象，然后获得从listCart.jsp传递过来的lineid(bookid)和num，最后根据lineid来获得指定的             Orderline对象，并且修改数量为num。
               3) 修改成功后跳转到shopCar.jsp页面

      3.5 清空购物车
      在shopCar.jsp页面中点击清空购物车后可以删除购物车中所有的Orderline。

      具体步骤：1) 在该Action中获得ShoppingCart对象，然后调用其中的dropLine()方法来清空购物车。
               3) 清空购物车成功后跳转到shopCar.jsp页面

    4.订单
      4.1查看用户所有订单
      在viewBook.jsp页面上点击查看用户订单按钮后可以查看当前登陆用户所有的订单信息。

      具体步骤：1) 实现IOrderFormDao接口中的listAllOrder()方法
               2) 实现IOrderFormService接口中的业务方法listAllOrder()
               3) 创建toMyOrders. action，在该Action中调用IOrderService接口中的listAllOrder()方法来查找用户的所有订单信息。
               4) 查找订单成功后跳转到myOrders.jsp页面，并将订单信息在该页面上显示。

      4.2 提交订单
      在shopCar.jsp页面上点击提交订单的按钮后链接到myOrders.jsp页面，然后在该页面上点击确认订单按钮后才正式提交订单，将订单信息分别保存到orderform和     orderline表中。
      具体步骤：1) 先链接到Order.jsp页面，在该页面上从Session中分别取出Customer和ShoppingCart对象并将它们的信息显示在页面，在该页面还可以修改用户信息。
               2) 实现IOrderDao接口中的saveOrder()方法
               3) 实现IOrderService接口中的业务方法saveOrder()
               4) 实现ICustomerService接口中的业务方法update()
               5) 创建ConfirmAction.java
               6) 获得Customer对象并更新属性信息
               7) 提交订单成功后跳转到confirm.jsp，失败跳转到order.jsp，在confirm.jsp页面上点击继续购买按钮可以跳转到index.jsp。
               8) 订单提交成功后清空购物车信息

      4.3 删除订单
      在myOrders.jsp页面上点击删除按钮可以删除指定的一个用户订单。

      具体步骤：1) 实现IOrderDao接口中的deleteOrder()方法
               2) 实现IOrderService接口中的业务方法delOrder()
               3) 创建DelOrder.action
               4) 在该Action中获得从myOrders.jsp传递过来的orderid，然后根据该orderid，调用IOrderService接口中的delOrder()方法删除指定的订单。
               5) 订单删除成功后跳转到toMyOrders.action

     5.支付
      订单提交完成后可以选择“支付”按钮，进入支付页面并选择支付方式，根据选择的支付方式分别调用支付宝与微信的支付接口完成支付；
      支付成功后更改订单状态，并展示订单信息；失败则返回订单页面，可以重新选择支付。
  
  ### 系统运行结果
  
  >运行环境：MyEclipse + Oracle + Tomcat + SpringMVC + Mybatis + JS <br>
  ![]() 
  <br>
  
  >主页、详情页、登录、注册、修改用户信息<br>
  ![]()<br>
  ![]()<br>
  ![]()<br>
  ![]()<br>
  ![]()
  <br>
  
  >购物车信息<br>
  ![]()
  <br>
  
  >订单信息<br>
  ![]()<br>
  ![]()<br>
  ![]()
  <br>
  
  >支付<br>
  ![]()<br>
  ![]()
  <br>

          

