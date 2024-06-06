document.addEventListener('DOMContentLoaded', function() {
    const taskInput = document.getElementById('new-task');
    const addTaskBtn = document.getElementById('add-task-btn');
    const todoList = document.getElementById('todo-list');
    const doingList = document.getElementById('doing-list');
    const doneList = document.getElementById('done-list');

    addTaskBtn.addEventListener('click', addTask);
    taskInput.addEventListener('keypress', function(event) {
        if (event.key === 'Enter') {
            addTask();
        }
    });

    function addTask() {
        const taskText = taskInput.value.trim();
        if (taskText === '') {
            alert('Por favor, insira uma tarefa');
            return;
        }

        const taskItem = createTaskItem(taskText);
        todoList.appendChild(taskItem);
        taskInput.value = '';
    }

    function createTaskItem(taskText) {
        const taskItem = document.createElement('li');
        taskItem.className = 'list-group-item task d-flex justify-content-between align-items-center';

        const taskContent = document.createElement('span');
        taskContent.textContent = taskText;

        const buttonGroup = document.createElement('div');
        buttonGroup.className = 'btn-group';

        const startBtn = document.createElement('button');
        startBtn.className = 'btn btn-warning btn-sm';
        startBtn.textContent = 'Começar';
        startBtn.addEventListener('click', function() {
            moveToDoing(taskItem);
        });

        const deleteBtn = document.createElement('button');
        deleteBtn.className = 'btn btn-danger btn-sm';
        deleteBtn.textContent = 'Deletar';
        deleteBtn.addEventListener('click', function() {
            taskItem.parentElement.removeChild(taskItem);
        });

        buttonGroup.appendChild(startBtn);
        buttonGroup.appendChild(deleteBtn);

        taskItem.appendChild(taskContent);
        taskItem.appendChild(buttonGroup);

        return taskItem;
    }

    function moveToDoing(taskItem) {
        doingList.appendChild(taskItem);
        const buttonGroup = taskItem.querySelector('.btn-group');
        buttonGroup.innerHTML = '';

        const completeBtn = document.createElement('button');
        completeBtn.className = 'btn btn-success btn-sm';
        completeBtn.textContent = 'Concluir';
        completeBtn.addEventListener('click', function() {
            moveToDone(taskItem);
        });

        const deleteBtn = document.createElement('button');
        deleteBtn.className = 'btn btn-danger btn-sm';
        deleteBtn.textContent = 'Deletar';
        deleteBtn.addEventListener('click', function() {
            taskItem.parentElement.removeChild(taskItem);
        });

        buttonGroup.appendChild(completeBtn);
        buttonGroup.appendChild(deleteBtn);
    }

    function moveToDone(taskItem) {
        doneList.appendChild(taskItem);
        const buttonGroup = taskItem.querySelector('.btn-group');
        buttonGroup.innerHTML = '';

        const deleteBtn = document.createElement('button');
        deleteBtn.className = 'btn btn-danger btn-sm';
        deleteBtn.textContent = 'Deletar';
        deleteBtn.addEventListener('click', function() {
            taskItem.parentElement.removeChild(taskItem);
        });

        buttonGroup.appendChild(deleteBtn);
    }
});
