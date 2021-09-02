package cn.echo.springcloud.mapper;

import cn.echo.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: cn.echo.springcloud.mapper
 * @Author: pluto
 * @CreateTime: 2021/8/27 6:20 下午
 * @Description: 部门数据访问层
 **/
@Mapper
@Repository
public interface DeptMapper {

    int addDept(Dept dept);

    Dept querById(Long deptno);

    List<Dept> queryAll();

}
