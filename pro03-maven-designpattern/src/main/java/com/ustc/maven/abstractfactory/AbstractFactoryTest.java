package com.ustc.maven.abstractfactory;

/**
 * @author Miracle
 * @date 2022/11/23 11:01
 * @description AbstractFactoryTest
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        IDatabaseUtils iDatabaseUtils = new OracleDataBaseUtils(); //
        IConnection connection = iDatabaseUtils.getConnection();
        connection.connect();
        ICommand command = iDatabaseUtils.getCommand();
        command.command();


    }
}

// 变化: mysql , oracle. ...
// connection , command ,

interface IConnection {
    void connect();
}

interface ICommand {
    void command();
}

interface IDatabaseUtils {
    IConnection getConnection();

    ICommand getCommand();
}

class MysqlConnection implements IConnection {

    @Override
    public void connect() {
        System.out.println("mysql connected.");
    }
}

class OracleConnection implements IConnection {

    @Override
    public void connect() {
        System.out.println("oracle connected.");
    }
}


class MysqlCommand implements ICommand {

    @Override
    public void command() {
        System.out.println(" mysql command. ");
    }
}

class OracleCommand implements ICommand {

    @Override
    public void command() {
        System.out.println("oracle command.");
    }
}

class MysqlDataBaseUtils implements IDatabaseUtils {

    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }
}

class OracleDataBaseUtils implements IDatabaseUtils {

    @Override
    public IConnection getConnection() {
        return new OracleConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}
