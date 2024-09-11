package com.example.rekazfinalproject.Service;


import com.example.rekazfinalproject.Api.ApiException;
import com.example.rekazfinalproject.Model.Bid;
import com.example.rekazfinalproject.Model.Investor;
import com.example.rekazfinalproject.Model.Project;
import com.example.rekazfinalproject.Repository.BidRepository;
import com.example.rekazfinalproject.Repository.InvestorRepository;
import com.example.rekazfinalproject.Repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor


public class BidService {

    private final BidRepository bidRepository;
    private final ProjectRepository projectRepository;
    private final InvestorRepository investorRepository;

    public List<Bid> findAllBids(){
        return bidRepository.findAll();
    }

    public void addBid( int investorId , int projectId , Bid bid) {

        Project project = projectRepository.findProjectById(projectId);

        if(project==null){
            throw new ApiException("Project not found");
        }

        Investor investor = investorRepository.findInvestorById(investorId);

        if(investor==null){
            throw new ApiException("Investor not found");
        }

        // investor cannot make many bids to same project

        for(Bid bid1 : project.getBids()) {
            if(bid1.getInvestor()==investor){
                throw new ApiException("you have already bid in this project");
            }
        }

        // when bid is approved other investors cannot add bids

        if(project.getStatus().equalsIgnoreCase("closed")){
            throw new ApiException("this project has a approved bid");
        }

        bid.setInvestor(investor);

        bid.setProject(project);

        bidRepository.save(bid);
    }

    public void updateBid(int id , Bid bid) {
        Bid bid1 = bidRepository.findBidById(id);

        if(bid1==null){
            throw new ApiException("Bid not found");
        }

        if(bid.getStatus().equalsIgnoreCase("approved")){
            throw new ApiException("Approved Bid cannot be updated");
        }

        bid1.setBudget(bid.getBudget());
        bid1.setDeadline(bid.getDeadline());
        bid1.setDescription(bid.getDescription());

        bidRepository.save(bid1);
    }

    public void deleteBid(int id) {
        Bid bid = bidRepository.findBidById(id);
        if(bid==null){
            throw new ApiException("Bid not found");
        }
        if(bid.getStatus().equalsIgnoreCase("approved")){
            throw new ApiException("Approved Bid cannot be deleted");
        }
        bidRepository.delete(bid);
    }


}
