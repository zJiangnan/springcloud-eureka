package cn.echo.springcloud.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Package: cn.echo.springcloud.pojo
 * @Author: pluto
 * @CreateTime: 2021/8/27 5:30 下午
 * @Description: 部门实体
 **/
@Data
@ApiModel(value = "部门实体类", description = "部门实体类")
@TableName("dept")
@Accessors(chain = true)//链式写法：Dept d = new Dept(); 可以一直set：d.setDeptno("1").setDname("部门").setDbSource("db_01")
public class Dept implements Serializable {

    private static final long serialVersionUID = 21632002453420159L;

    @ApiModelProperty(value = "主键", notes = "部门编码")
    @TableId("deptno")
    private Long deptno;

    @ApiModelProperty("部门名称")
    private String dname;

    @ApiModelProperty(value = "来自那个数据库", notes = "微服务：一个服务对应一个数据库，同一个信息可能存在不同的数据库")
    private String dbSource;

}
