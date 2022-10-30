package service.impl;

import dao.IUserDao;
import dao.impl.UserDaolmpl;
import service.IUserService;

public class UserServiceImpl implements IUserService {
    /**
     * 调用数据访问层
     * @author wtq
     */

   // IUserDao iUserDao = new UserDaolmpl(); //用接口调用类，可以降低耦合，修改方法时，可新建一个实现类，
    // 只需修改后半部分即可，使用ioc后，新建对象交给容器管理更进一步降低耦合，把new的动作交给了spring
    IUserDao iUserDao; //需要提供set方法

    public IUserDao getiUserDao() {
        return iUserDao;
    }

    public void setiUserDao(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }

    @Override
    public void getUser() {
        iUserDao.getUser();
    }
}
