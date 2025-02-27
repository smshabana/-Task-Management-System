@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired private TaskRepository taskRepo;

    @PostMapping public Task createTask(@RequestBody Task task) {
        return taskRepo.save(task);
    }

    @GetMapping public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    @PutMapping("/{id}") public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        Task task = taskRepo.findById(id).orElseThrow();
        task.setTitle(taskDetails.getTitle());
        task.setStatus(taskDetails.getStatus());
        return taskRepo.save(task);
    }

    @DeleteMapping("/{id}") public void deleteTask(@PathVariable Long id) {
        taskRepo.deleteById(id);
    }
}
