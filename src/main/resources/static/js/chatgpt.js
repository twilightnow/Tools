function sendMessage() {
    var userInput = document.getElementById('user-input').value;
    console.log("Sending message:", userInput); // 记录发送的消息

    var chatWindow = document.getElementById('output');

    // 清空输入框并添加消息到聊天窗口
    document.getElementById('user-input').value = '';
    chatWindow.innerHTML += `<div>User: ${userInput}</div>`;

    // 构建请求数据
    var data = { prompt: userInput };

    // 使用 Fetch API 发送数据到后端
	fetch('/api/chatgpt/ask', {
	    method: 'POST',
	    headers: {
	        'Content-Type': 'application/json'
	    },
	    body: JSON.stringify(data)
	})
	.then(response => response.json())
	.then(data => {
		console.log("data:", data);
	    if (data && data.choices && data.choices.length > 0) {
	        // 提取 assistant 的回复内容
	        
	        const replyContent = data.choices[0].message.content;
	        chatWindow.innerHTML += `<div>GPT: ${replyContent}</div>`;
	        console.log("replyContent:", replyContent);
	    } else {
	        // 如果没有回复内容，显示一条默认消息
	        chatWindow.innerHTML += `<div>GPT: No response received</div>`;
	    }
	    chatWindow.scrollTop = chatWindow.scrollHeight; // 滚动到最新的消息
	})
	.catch((error) => {
	    console.error('Error:', error);
	});

}
