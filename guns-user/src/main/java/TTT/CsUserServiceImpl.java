package TTT;

import com.stylefeng.guns.user.common.persistence.model.CsUser;
import com.stylefeng.guns.user.common.persistence.dao.CsUserMapper;
import TTT.ICsUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wxf
 * @since 2019-10-15
 */
@Service
public class CsUserServiceImpl extends ServiceImpl<CsUserMapper, CsUser> implements ICsUserService {

}
