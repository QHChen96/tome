package com.khetao.tome.trade.infra.repo;

import com.khetao.tome.dto.SingleResponse;
import com.khetao.tome.member.dto.MemberDTO;
import com.khetao.tome.member.facade.MemberClientFacade;
import com.khetao.tome.trade.domain.model.Buyer;
import com.khetao.tome.trade.domain.repo.BuyerRepo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * 将member服务暴露的接口，转为本地repo
 * @author chenqinhao 2022/7/15
 * @email qhchen96@gmail.com
 */
@Named
public class BuyerRepoImpl implements BuyerRepo {

    @Inject
    private MemberClientFacade memberClientFacade;

    @Override
    public Buyer getBuyer(Long buyerId) {
        SingleResponse<MemberDTO> memberResponse = memberClientFacade.getMember(buyerId);
        if (memberResponse == null) {
            return null;
        }
        MemberDTO memberDTO = memberResponse.getData();
        Buyer buyer = new Buyer();
        buyer.setBuyerId(memberDTO.getMemberId());
        buyer.setBuyerName(memberDTO.getMemberName());
        return buyer;
    }

}
