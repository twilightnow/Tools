		fetch('/kana')
			.then(response => response.json())
			.then(data => {
				const container = document.getElementById('kana-container');
				data.forEach(kana => {
					const kanaElement = document.createElement('div');
					kanaElement.innerHTML = `<strong>平假名:</strong> ${kana.hiragana} <strong>片假名:</strong> ${kana.katakana} <strong>罗马字:</strong> ${kana.romaji}`;
					container.appendChild(kanaElement);
				});
			});