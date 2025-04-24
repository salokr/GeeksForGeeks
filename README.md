# 🧠 PyCode-TextEE  
> Efficient and extensible Event Extraction with prompt optimization — built on top of [TextEE](https://github.com/ej0cl6/TextEE)

---

<div align="center">

[![🛠️ Updates](https://img.shields.io/badge/🛠️%20Updates-Click%20Here-informational?style=flat-square)](#️-updates) •
[![📂 Datasets](https://img.shields.io/badge/📂%20Datasets-17%20Supported-brightgreen?style=flat-square)](#️-datasets) •
[![⚙️ Environment](https://img.shields.io/badge/⚙️%20Environment-Setup-orange?style=flat-square)](#️-environment) •
[![🚀 Running](https://img.shields.io/badge/🚀%20Running-Instructions-blueviolet?style=flat-square)](#️-running) •
[![🌐 Website](https://img.shields.io/badge/🌐%20Website-Demo%20Soon-lightgrey?style=flat-square)](#️-website) •
[![📄 Paper](https://img.shields.io/badge/📄%20arXiv-2502.16377-b31b1b?style=flat-square)](https://arxiv.org/abs/2502.16377)

</div>

---

**Authors**:  
Saurabh Srivastava, Sweta Pati, Ziyu Yao

---

## 🧩 Introduction

**PyCode-TextEE** extends [TextEE](https://github.com/ej0cl6/TextEE), bringing **event extraction into the era of prompt-based large language models**.

While **TextEE** standardizes 10+ event extraction datasets into a unified JSON format—making them reproducible and comparable—**PyCode-TextEE** takes the next leap:

> ✨ We transform TextEE-formatted data into **code-style prompts**—a format that is both readable and executable by LLMs and ideal for structured evaluation.

---

### 🚀 What’s New in PyCode-TextEE?

- 🧱 **CodePrompt Format Conversion**  
  We convert event structures (event triggers, arguments—if available) into Python-like prompts (e.g., `Attack(mention="...", attacker=[...], target=[...])`) to help LLMs handle structured outputs.

- 📦 **Plug-and-Play with TextEE**  
  Directly load standardized datasets from TextEE and transform them with one command into training-ready CodePrompts.

- 🧪 **Evaluation Toolkit for Prompted LLMs**  
  We provide exact-match evaluation utilities that compute **precision, recall, and F1 scores** over structured LLM outputs.

- 📁 **Upcoming Paper-Compatible Training Pipelines**  
  Includes all data transformations and training scripts used in a paper currently under submission to a major NLP conference. Code for that will live in `LLaMAEvents/`.

## 🛠️ Updates

- **April 23, 2025** — We release **PyCode-TextEE**, a modular framework for converting standardized event extraction datasets (via TextEE) into code-style prompts, along with exact-match evaluation scripts.  
  Feel free to reach out if you’d like to contribute your **models**, **datasets**, or ideas!

## 📂 Supported Datasets

We support **17 datasets** for Event Detection (ED), Event Argument Extraction (EAE), and End-to-End (E2E) Event Extraction.  
All are converted into **code-style prompts** and support evaluation using our exact-match metric suite.  
The table below also shows whether annotation **guidelines** are included for each dataset.

<div align="center">
<table>
<thead>
<tr>
  <th><strong>Dataset</strong></th>
  <th><strong>Task(s)</strong></th>
  <th><strong>Paper Title</strong></th>
  <th><strong>Source</strong></th>
  <th><strong>Guidelines</strong></th>
</tr>
</thead>
<tbody>
<tr>
  <td><code>ACE05</code></td>
  <td>ED, EAE, E2E</td>
  <td>The Automatic Content Extraction (ACE) Program</td>
  <td><a href="https://www.ldc.upenn.edu/">LDC</a></td>
  <td>🔘</td>
</tr>
<tr>
  <td><code>ERE</code></td>
  <td>ED, EAE, E2E</td>
  <td>From Light to Rich ERE</td>
  <td><a href="https://www.ldc.upenn.edu/">LDC</a></td>
  <td>🔘</td>
</tr>
<tr>
  <td><code>MLEE</code></td>
  <td>ED, EAE, E2E</td>
  <td>Biological Event Extraction</td>
  <td><a href="https://academic.oup.com/bioinformatics/article/28/18/i575/245077">Bioinformatics</a></td>
  <td>⚪️</td>
</tr>
<tr>
  <td><code>Genia2011</code></td>
  <td>ED, EAE, E2E</td>
  <td>Genia Event Task (2011)</td>
  <td><a href="https://www.aclweb.org/anthology/W11-1801/">BioNLP 2011</a></td>
  <td>⚪️</td>
</tr>
<tr>
  <td><code>Genia2013</code></td>
  <td>ED, EAE, E2E</td>
  <td>Genia Event Task (2013)</td>
  <td><a href="https://www.aclweb.org/anthology/W13-5201/">BioNLP 2013</a></td>
  <td>⚪️</td>
</tr>
<tr>
  <td><code>M2E2</code></td>
  <td>ED, EAE, E2E</td>
  <td>Cross-media Structured Common Space</td>
  <td><a href="https://aclanthology.org/2020.acl-main.188/">ACL 2020</a></td>
  <td>⚪️</td>
</tr>
<tr>
  <td><code>CASIE</code></td>
  <td>ED, EAE, E2E</td>
  <td>CASIE: Cybersecurity Event Extraction</td>
  <td><a href="https://ojs.aaai.org/index.php/AAAI/article/view/6155">AAAI 2020</a></td>
  <td>⚪️</td>
</tr>
<tr>
  <td><code>PHEE</code></td>
  <td>ED, EAE, E2E</td>
  <td>Pharmacovigilance Event Extraction</td>
  <td><a href="https://aclanthology.org/2022.emnlp-main.343/">EMNLP 2022</a></td>
  <td>⚪️</td>
</tr>
<tr>
  <td><code>MEE</code></td>
  <td>ED</td>
  <td>Multilingual Event Extraction</td>
  <td><a href="https://aclanthology.org/2022.emnlp-main.428/">EMNLP 2022</a></td>
  <td>⚪️</td>
</tr>
<tr>
  <td><code>FewEvent</code></td>
  <td>ED</td>
  <td>Few-Shot Event Detection</td>
  <td><a href="https://dl.acm.org/doi/10.1145/3336191.3371962">WSDM 2020</a></td>
  <td>⚪️</td>
</tr>
<tr>
  <td><code>MAVEN</code></td>
  <td>ED</td>
  <td>Massive General-Domain ED</td>
  <td><a href="https://aclanthology.org/2020.emnlp-main.154/">EMNLP 2020</a></td>
  <td>⚪️</td>
</tr>
<tr>
  <td><code>SPPED</code></td>
  <td>ED</td>
  <td>ED from Social Media for Epidemic Prediction</td>
  <td><a href="https://aclanthology.org/2024.naacl-main.172/">NAACL 2024</a></td>
  <td>⚪️</td>
</tr>
<tr>
  <td><code>MUC-4</code></td>
  <td>EAE</td>
  <td>Fourth Message Understanding Conference</td>
  <td><a href="https://www-nlpir.nist.gov/related_projects/muc/">MUC 1992</a></td>
  <td>⚪️</td>
</tr>
<tr>
  <td><code>RAMS</code></td>
  <td>EAE</td>
  <td>Multi-Sentence Argument Linking</td>
  <td><a href="https://aclanthology.org/2020.acl-main.743/">ACL 2020</a></td>
  <td>🔘</td>
</tr>
<tr>
  <td><code>WikiEvents</code></td>
  <td>EAE</td>
  <td>Conditional Generation for Doc-level EAE</td>
  <td><a href="https://aclanthology.org/2021.naacl-main.417/">NAACL 2021</a></td>
  <td>🔘</td>
</tr>
<tr>
  <td><code>GENEVA</code></td>
  <td>EAE</td>
  <td>Benchmarking Generalizability for EAE</td>
  <td><a href="https://aclanthology.org/2023.acl-long.794/">ACL 2023</a></td>
  <td>🔘</td>
</tr>
</tbody>
</table>


</div>

## ⚙️ Environment

We recommend using **Python 3.9+** with a clean virtual environment (e.g., via `venv` or `conda`).

### 🔹 Install Dependencies
```bash
# Clone the repo
git clone https://github.com/yourname/PyCode-TextEE.git
cd PyCode-TextEE

# Create a virtual environment (optional)
python3 -m venv env
source env/bin/activate  # On Windows: env\Scripts\activate

# Install requirements
pip install -r requirements.txt
```

### 🔹 Core Dependencies
- `transformers` ≥ 4.x  
- `datasets`  
- `openai`  
- `scikit-learn`  
- `tqdm`  
- `wandb` (optional for experiment tracking)  

### ⚠️ Note
Some datasets (e.g., ACE, ERE) require **LDC license** to access raw files.  We provide code for preprocessing them, but not the data itself.


## 🚀 Running the Code

Below is a step-by-step guide to run PyCode-TextEE.  
Our pipeline is divided into two main stages:

---

### 🌱 Step 1 — [Optional] Generate Code Schema

If you're working with custom datasets (or want to regenerate schemas for the 17 supported ones), you'll first convert them into **TextEE format** and generate the corresponding **Python-style event definitions**.

📁 Directory structure:
```
PyCode-TextEE/
├── code_schema_generation/
│   ├── generate_schema.py
│   ├── init_prompts/            # Contains per-dataset class schemas (*.txt)
│   ├── python_event_defs/       # Python classes for eval (dataset-wise + all_ee_definitions.py)
│   ├── mapper.json              # Maps cleaned names → class names
│   └── schema.json              # All cleaned event/arg schemas
```

👾 Example output schema (for ACE05 `Attack` event):
```python
@dataclass
class Attack(ConflictEvent):
    mention: str
    target: List
    victim: List
    attacker: List
    instrument: List
    place: List
    agent: List
```

🛠 To generate schema:
```bash
cd code_schema_generation
python generate_schema.py --dataset_folder <your_dataset_dir>
```

📂 Expected dataset layout:
```
<your_dataset_dir>/
├── ace05-en/
│   ├── split1/
│   │   ├── train.json
│   │   ├── dev.json
│   │   └── test.json
│   └── ...
├── casie/
└── ...
```

**Note**: We’ve already generated schema for all 17 supported datasets. This step is only required for new datasets.

---

### 🔹 Step 2: Convert to Code Prompts

Run the following:

```bash
cd code_prompts
python prepare_dataset.py \
    --input_dir ../../TextEE/processed_data \
    --dataset_name ace05-en \
    --annotate_schema True \
    --guideline_file ace05-en \
    --add_negative_samples True \
    --output_dir ./processed_code_prompts/
```

---

### ⚙️ Argument Descriptions

| Argument               | Description |
|------------------------|-------------|
| `--input_dir`          | Path to TextEE-formatted JSONs (default: `../../TextEE/processed_data`) |
| `--dataset_name`       | Name of the dataset to process (e.g., `ace05-en`) |
| `--annotate_schema`    | Add class docstrings and inline comments using guidelines (default: `False`) |
| `--guideline_file`     | Guideline JSON file for schema annotation (required if `annotate_schema=True`) |
| `--add_negative_samples` | Add negative examples to training set (default: `False`) |
| `--output_dir`         | Where to save the converted code prompts (default: `./processed_code_prompts/`) |

---

### 🧬 Annotated Prompt Example (with Guidelines)

When `--annotate_schema=True`, we generate prompts like:

```python
@dataclass
class Die(LifeEvent):
    """the event def"""
    mention: str  # ... definition of argument
    place: List   # ... definition of argument
    instrument: List  # ... definition of argument
    victim: List  # ... definition of argument
    person: List  # ... definition of argument
    agent: List   # ... definition of argument
```

This format supports **LLM-compatible** structure learning and improves interpretability.

---

### 📘 Guideline File Format

Your `guideline_file` should look like:

```json
{
  "EventName1": {
    "description": [
      "One possible definition.",
      "Another variation of the same."
    ],
    "attributes": {
      "mention": "Trigger span of the event.",
      "agent": "Entity responsible for the event."
    }
  }
}
```

This enables *randomized sampling* during conversion to avoid overfitting to one phrasing—an approach highlighted in our arXiv/ACL paper.

---

### 💡 Tip
⓵ Skip `--guideline_file` and `--annotate_schema` if you're only interested in raw code prompts.  
⓶ Use `--add_negative_samples` if you want to add negative sample per instance similar to DEGREE.




