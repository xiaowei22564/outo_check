function voideerror() {
		//promise
		fetch(`/home/AbcTime/socket`).then(res => {
			return res.text();
		}).then(data => {
			document.getElementById("socket").innerText = data;
		})
		
		fetch(`/home/AbcTime/Carton`).then(res => {
			return res.text();
		}).then(data => {
			document.getElementById("carton").innerText = data;
		})
		
		fetch(`/home/AbcTime/video`).then(res => {
			return res.text();
		}).then(data => {
			document.getElementById("video").innerText = data;
		})
		
		fetch(`/home/AbcTime/erorrsocket`).then(res => {
			return res.text();
		}).then(data => {
			console.log(JSON.parse(data));
			var res = JSON.parse(data);
			var htmldata = "";
		
			for(var i=0;i<res.length;i++){
				var item = res[i];
				htmldata += `<tr>
							<th scope="row">${i+1}</th>
							<td>${item.channel}</td>
							<td>${item.lessonid}</td>
							<td>${item.app_edition}</td>
							<td>${item.devices}</td>
							<td>${item.system}</td>
							<td>${item.date}</td>
							<td>${item.socket_Error}</td>
							<td>${item.route}</td>
						</tr>`
			}
			document.getElementById("tbody").innerHTML = htmldata;
			
		})
		
		fetch(`/home/AbcTime/erorrvideo`).then(res => {
			return res.text();
		}).then(data => {
			var res = JSON.parse(data);
			var htmldata = "";
		
			for(var i=0;i<res.length;i++){
				var item = res[i];
				htmldata += `<tr>
							<th scope="row">${i+1}</th>
							<td>${item.channel}</td>
							<td>${item.lessonid}</td>
							<td>${item.app_edition}</td>
							<td>${item.devices}</td>
							<td>${item.system}</td>
							<td>${item.date}</td>
							<td>${item.video_Error}</td>
							<td>${item.route}</td>
						</tr>`
			}
			document.getElementById("videoer").innerHTML = htmldata;
			
		})
		
		fetch(`/home/AbcTime/maxdevices`).then(res => {
			return res.json();
		}).then(async (data) => {
			const div = document.getElementById("phoneRank");
			var html = "";
			let res = await fetch(`/home/AbcTime/DrivesPercentage`);
			let resdata = await res.json();
			for(let i=0;i<data.length;i++){
				let item = data[i];
				item.drives = resdata[i];
				html += `<span>${item.device}</span>
						 <div class="progress">
							<div class="progress-bar progress-bar-striped progress-bar-animated width-pb75" style="width:${item.drives}%" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100">${item.num}</div>
						</div>`
			}
			
			div.innerHTML = html;
			
			
			return data;
		})
	}
	window.onload = function(){
		voideerror();
		
		
	}
	

	