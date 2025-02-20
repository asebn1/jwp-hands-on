package aop.stage2;

import aop.stage1.TransactionAdvice;
import aop.stage1.TransactionAdvisor;
import aop.stage1.TransactionPointcut;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class AopConfig {
    @Bean
    TransactionPointcut transactionPointcut() {
        return new TransactionPointcut();
    }

    @Bean
    TransactionAdvice transactionAdvice(final PlatformTransactionManager transactionManager) {
        return new TransactionAdvice(transactionManager);
    }

    @Bean
    TransactionAdvisor transactionAdvisor(final TransactionPointcut transactionPointcut,
                                          final TransactionAdvice transactionAdvice) {
        return new TransactionAdvisor(transactionPointcut, transactionAdvice);
    }

    @Bean
    DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }
}
