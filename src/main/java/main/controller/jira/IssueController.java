package main.controller.jira;

import lombok.RequiredArgsConstructor;
import main.dto.issue.Issue;
import main.service.jira.IssuesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static main.util.PageUri.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ISSUE)
public class IssueController {

    private final IssuesService issuesService;

    @PostMapping(CREATE)
    public ResponseEntity<String> createIssue(@RequestBody Issue issue){
        return ResponseEntity.ok("Issue with ID " + issuesService.createIssue(issue) + " was created");
    }

    @DeleteMapping(DELETE)
    public String deleteIssueById(@PathVariable String id){
        return issuesService.deleteIssueById(id);
    }

    @GetMapping(ASSIGNED_TO_USER)
    public ResponseEntity<String> getIssuesAssignedToUser(@PathVariable String username){
        return issuesService.getIssuesAssignedToUser(username);
    }
}
