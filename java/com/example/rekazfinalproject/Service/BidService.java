package com.example.rekazfinalproject.Service;


import com.example.rekazfinalproject.Api.ApiException;
import com.example.rekazfinalproject.Model.Bid;
import com.example.rekazfinalproject.Model.Project;
import com.example.rekazfinalproject.Repository.BidRepository;
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

    public List<Bid> findAllBids(){
        return bidRepository.findAll();
    }

    public void addBid( int projectId , Bid bid) {

        Project project = projectRepository.findProjectById(projectId);

        if(project==null){
            throw new ApiException("Project not found");
        }

        bid.setProject(project);

        bidRepository.save(bid);
    }

    public void updateBid(int id , Bid bid) {
        Bid bid1 = bidRepository.findBidById(id);

        bid1.setBudget(bid.getBudget());
        bid1.setDeadline(bid.getDeadline());
        bid1.setDescription(bid.getDescription());

        bidRepository.save(bid1);
    }

    public void deleteBid(int id) {
        Bid bid = bidRepository.findBidById(id);
        bidRepository.delete(bid);
    }


}
